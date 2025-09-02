package com.example.demo.controller;

import com.example.demo.dto.WebChatRequest;
import com.example.demo.service.LmStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LmStudioController {

    @Autowired
    private LmStudioService lmStudioService;

    @PostMapping("/generate")
    public String generate(@RequestBody WebChatRequest webChatRequest) {
        return lmStudioService.generateText(webChatRequest);
    }
}