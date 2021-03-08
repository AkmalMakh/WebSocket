package com.javamaster.service.chatService;

import com.javamaster.model.ChatRoom;
import com.javamaster.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ChatServiceImpl implements ChatService{

    private final ChatRoomRepository chatRoomRepository;

    public ChatServiceImpl(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }



    @Override
    public Set<ChatRoom> getChats() {
        Set<ChatRoom>chatRooms = new HashSet<>();
        chatRoomRepository.findAll().iterator().forEachRemaining(chatRooms::add);
        return chatRooms;
    }
}
