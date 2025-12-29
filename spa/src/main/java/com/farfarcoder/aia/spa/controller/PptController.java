package com.farfarcoder.aia.spa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aia/ppt")
public class PptController {

    @GetMapping
    public String ppt() {
        return "ppt-view";
    }
}
