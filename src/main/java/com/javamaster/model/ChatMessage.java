//package com.javamaster.model;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//public class ChatMessage {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;
//
//    @ManyToOne
//    private ChatRoom chatRoom;
//
//
//    private String chatId;
//
//    private String senderId;
//
//    private String receiverId;
//
//    private String senderName;
//
//    private String receiverName;
//
//    private String messageText;
//
//    private Date timestamp;
//
//    public ChatMessage() {
//
//    }
//
//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//
//
//    public String getChatId() {
//        return chatId;
//    }
//
//    public void setChatId(String chatId) {
//        this.chatId = chatId;
//    }
//
//    public String getSenderId() {
//        return senderId;
//    }
//
//    public void setSenderId(String senderId) {
//        this.senderId = senderId;
//    }
//
//    public String getReceiverId() {
//        return receiverId;
//    }
//
//    public void setReceiverId(String receiverId) {
//        this.receiverId = receiverId;
//    }
//
//    public String getSenderName() {
//        return senderName;
//    }
//
//    public void setSenderName(String senderName) {
//        this.senderName = senderName;
//    }
//
//    public String getReceiverName() {
//        return receiverName;
//    }
//
//    public void setReceiverName(String receiverName) {
//        this.receiverName = receiverName;
//    }
//
//    public String getMessageText() {
//        return messageText;
//    }
//
//    public void setMessageText(String messageText) {
//        this.messageText = messageText;
//    }
//
//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public ChatRoom getChatRoom() {
//        return chatRoom;
//    }
//
//    public void setChatRoom(ChatRoom chatRoom) {
//        this.chatRoom = chatRoom;
//    }
//}
