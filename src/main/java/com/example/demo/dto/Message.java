package com.example.demo.dto;

public  class Message {
    private String role;
    private String content;

    // Конструкторы
    public Message() {}

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    // Геттеры и сеттеры
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
