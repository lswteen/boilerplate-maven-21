package com.farfarcoder.aia.core.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Component
public class AccessLogFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger("API_LOGGER");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();
        String requestId = UUID.randomUUID().toString();
        // requestId generally should be put in MDC for global tracing, but here we just
        // use it for single line log.

        try {
            filterChain.doFilter(requestWrapper, responseWrapper);
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            String requestBody = new String(requestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8)
                    .replaceAll("\\s+", " "); // Minimize whitespace

            String responseBody;
            String uri = request.getRequestURI();
            if (uri.startsWith("/api")) {
                responseBody = new String(responseWrapper.getContentAsByteArray(), StandardCharsets.UTF_8)
                        .replaceAll("\\s+", " ");
            } else {
                responseBody = "[SKIP]";
            }

            log.info(
                    "appno:1000 | requestId:{} | clientIp:{} | useragent:{} | uri:{} | method:{} | status:{} | duration:{}ms | requestbody:{} | responsebody:{}",
                    requestId,
                    getClientIp(request),
                    request.getHeader("User-Agent"),
                    uri,
                    request.getMethod(),
                    response.getStatus(),
                    duration,
                    requestBody,
                    responseBody);

            responseWrapper.copyBodyToResponse();
        }
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
