package com.farfarcoder.aia.spa.controller;

import com.farfarcoder.aia.api.service.MockService;
import com.farfarcoder.aia.core.domain.MockData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/aia/dashboard")
public class DashboardController {

    private final MockService mockService;

    public DashboardController(MockService mockService) {
        this.mockService = mockService;
    }

    @GetMapping
    public String dashboard(Model model) {
        List<MockData> mockDataList = mockService.getMockDataList();
        model.addAttribute("mockDataList", mockDataList);
        return "dashboard-view";
    }
}
