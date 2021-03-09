package com.javamaster.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class ChatMessage { // Messages of chat

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE,
                          CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;


    @Column(name = "message_id")
    private String messageId;

    @Column(name = "chat_id")
    private String chatId;


    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "receiver_id")
    private String receiverId;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "created_at")
    private Date timestamp;

    public ChatMessage() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }



    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String chatId) {
        this.messageId = chatId;
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

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "Id=" + Id +
                ", chatRoom=" + chatRoom +
                ", messageId='" + messageId + '\'' +
                ", chatId='" + chatId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", messageText='" + messageText + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
