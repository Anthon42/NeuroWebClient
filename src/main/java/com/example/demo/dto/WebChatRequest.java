package com.example.demo.dto;

public class WebChatRequest {
    private String prompt;
    private String systemContext;

    // Конструкторы
    public WebChatRequest() {}

    public WebChatRequest(String prompt, String systemContext) {
        this.prompt = prompt;
        this.systemContext = systemContext;
    }

    // Геттеры и сеттеры
    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getSystemContext() {
        return systemContext;
    }

    public void setSystemContext(String systemContext) {
        this.systemContext = systemContext;
    }
}