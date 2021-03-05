package com.javamaster.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ChatRoom {


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "message")
    private Set<ChatMessage> chatMessages;



    private String id;

    private String chatId;

    private String senderId;

    private String receiverId;

    public ChatRoom() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(Set<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }
}
