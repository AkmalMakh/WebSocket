//package com.javamaster.controller;
//
//import com.javamaster.model.ChatRoom;
//
//import com.javamaster.service.chatService.ChatService;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/api")
//public class ChatRestController {
//
//    private ChatService chatService;
//
//    public ChatRestController(ChatService chatService) {
//        this.chatService = chatService;
//    }
//
//    @GetMapping("/{userId}/{chats}")
//    public Set<ChatRoom> findAll(){
//        return chatService.getChats();
//    }
//}
