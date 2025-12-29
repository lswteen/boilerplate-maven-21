package com.farfarcoder.aia.api.controller;

import com.farfarcoder.aia.api.service.MockService;
import com.farfarcoder.aia.api.domain.MockData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mocks")
public class MockApiController {

    private final MockService mockService;

    public MockApiController(MockService mockService) {
        this.mockService = mockService;
    }

    @GetMapping
    public List<MockData> getMocks() {
        return mockService.getMockDataList();
    }
}
