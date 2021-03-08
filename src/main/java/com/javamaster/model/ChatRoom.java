package com.javamaster.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ChatRoom")
public class ChatRoom {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(mappedBy = "chatRoom",
                    cascade = {CascadeType.DETACH , CascadeType.MERGE,
                            CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<ChatMessage> chatMessages;


    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;



    private String chatId;

    private String senderId;

    private String receiverId;

    public ChatRoom() {

    }

    public Long getId() {
        return Id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // add convenience method for bi-directional relationship

    public void addMessages(ChatMessage chatMessage){
        if(chatMessage == null){
            chatMessage  = new ChatMessage();
        }
        chatMessage.setChatRoom(this);
    }
}
