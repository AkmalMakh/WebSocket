package com.javamaster.controller;


import com.javamaster.model.ChatMessage;
import com.javamaster.model.ChatRoom;
import com.javamaster.model.User;
import com.javamaster.service.chatRoomService.ChatRoomService;
import com.javamaster.service.messageService.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatMessageController {

    private MessageService messageService;
    private ChatRoomService chatRoomService;

    @Autowired
    public ChatMessageController(MessageService messageService, ChatRoomService chatRoomService) {
        this.messageService = messageService;
        this.chatRoomService = chatRoomService;
    }

    @GetMapping("chatroom/{chatroomId}/messages")
    public Iterable<ChatMessage> findChatAllMessages(@PathVariable Long chatroomId){

        return messageService.getChatRoomsAllMessages(chatroomId);
    }

    @PostMapping("chatroom/{chatroomId}/messages")
    public ChatMessage addMessagetoChatRoom(@PathVariable final Long chatroomId,
                                            @RequestBody ChatMessage theChatMessages){
        ChatRoom chatRoom = chatRoomService.findById(chatroomId);
        if(chatRoom == null){
            throw new RuntimeException("User id not found - "+ chatroomId);
        }
        chatRoom.addMessages(theChatMessages);
        chatRoomService.save(chatRoom);
        messageService.save(theChatMessages);

        return theChatMessages;
    }

    @DeleteMapping("chatroom/{chatroomId}/messages/{messageId}")
    public String deleteMessageFromChatRoom(@PathVariable final Long chatroomId,
                                         @PathVariable final  Long messageId){
        ChatRoom chatRoom = chatRoomService.findById(chatroomId);
        if(chatRoom == null){
            throw new RuntimeException("User id not found - "+ chatroomId);
        }
        ChatMessage chatMessage = messageService.findById(messageId);

        chatRoom.deleteMessage(chatMessage);

        messageService.deleteMessageById(messageId);

        return "Deleted Message " +messageId+ " of chat room:  "+ chatroomId;
    }

}
