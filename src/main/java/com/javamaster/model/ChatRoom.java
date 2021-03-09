package com.javamaster.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chatroom")
public class ChatRoom {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @OneToMany(mappedBy = "chatRoom",
                    cascade = {CascadeType.DETACH , CascadeType.MERGE,
                            CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<ChatMessage> chatMessages;


    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;


    @Column(name = "chat_id")
    private String chatId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "receiver_id")
    private String receiverId;

    @Column(name = "created_at")
    private String createdAt;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public String toString() {
        return "ChatRoom{" +
                "Id=" + Id +
                ", chatMessages=" + chatMessages +
                ", user=" + user +
                ", chatId='" + chatId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
