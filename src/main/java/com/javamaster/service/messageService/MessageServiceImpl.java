package com.javamaster.service.messageService;

import com.javamaster.model.ChatMessage;
import com.javamaster.model.ChatRoom;
import com.javamaster.repository.MessageRepository;
import com.javamaster.service.chatRoomService.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MessageServiceImpl  implements MessageService{

    private ChatRoomService chatRoomService;
    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(ChatRoomService chatRoomService, MessageRepository messageRepository) {
        this.chatRoomService = chatRoomService;
        this.messageRepository = messageRepository;
    }

    @Override
    public Set<ChatMessage> getChatRoomsAllMessages(Long chatId) {
        ChatRoom chatRoom = chatRoomService.findById(chatId);
        if(chatRoom == null){
            throw new RuntimeException("User is not found"+ chatId);
        }
        Set<ChatMessage> chatMessages = chatRoom.getChatMessages();


        return chatMessages;
    }

    @Override
    public ChatMessage findById(Long messageId) {
        return messageRepository.findById(messageId).get();
    }

    @Override
    public void save(ChatMessage theMessage) {
        messageRepository.save(theMessage);

    }

    @Override
    public void deleteMessageById(Long theId) {
        messageRepository.deleteById(theId);
    }
}
