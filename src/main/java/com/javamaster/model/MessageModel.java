package com.javamaster.model;

public class MessageModel {

    private String message;
    private String senderName;
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "message='" + message + '\'' +
                ", senderName='" + senderName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
