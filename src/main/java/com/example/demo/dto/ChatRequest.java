package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRequest {

    private String model = "qwen/qwen3-coder-30b";
    private List<Message> messages;
    private Double temperature = 1.0;
    private Integer max_tokens = -1;
    private Boolean stream;

    // Конструкторы
    public ChatRequest() {
        this.messages = new ArrayList<>();
    }

    public ChatRequest(String model, List<Message> messages, Double temperature, Integer maxTokens, Boolean stream) {
        this.model = model;
        this.messages = messages != null ? messages : new ArrayList<>();
        this.temperature = temperature;
        this.max_tokens = maxTokens;
        this.stream = stream;
    }

    // Метод для добавления сообщения
    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void addSystemMessage(String role, String content) {
        for (Message oldMessage : this.messages) {
            if (oldMessage.getRole().equals(role)) {
                oldMessage.setContent(content);
                return;
            }
        }
        addMessage(new Message(role, content));
    }

    // Метод для добавления сообщения по роли и содержимому
    public void addMessage(String role, String content) {
        addMessage(new Message(role, content));
    }

    // Геттеры и сеттеры для всех полей...
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public List<Message> getMessages() { return messages; }
    public void setMessages(List<Message> messages) { this.messages = messages; }
    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
    public Integer getMaxTokens() { return max_tokens; }
    public void setMaxTokens(Integer maxTokens) { this.max_tokens = maxTokens; }
    public Boolean getStream() { return stream; }
    public void setStream(Boolean stream) { this.stream = stream; }
}