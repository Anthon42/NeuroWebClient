package com.example.demo.service;

import com.example.demo.config.RestTemplateConfig;
import com.example.demo.dto.ChatCompletionResponse;
import com.example.demo.dto.ChatRequest;
import com.example.demo.dto.WebChatRequest;
import com.example.demo.dto.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LmStudioService {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final ChatRequest request = new ChatRequest();

    public LmStudioService(RestTemplateConfig restTemplateConfig, @Value("${lmstudio.api-url}") String apiUrl) {
        this.restTemplate = restTemplateConfig.restTemplate();
        this.apiUrl = apiUrl;
    }

    public String generateText(WebChatRequest webChatRequest) {
        request.addSystemMessage("system", webChatRequest.getSystemContext());
        request.addMessage("user", webChatRequest.getPrompt());

        ChatCompletionResponse response = restTemplate.postForObject(apiUrl, request, ChatCompletionResponse.class);
        if (response.getLastChoice().getMessage() != null) {
            request.addMessage(response.getLastChoice().getMessage());
        }


        return response != null ? response.getLastChoice().getMessage().getContent() : "No response";


    }
}