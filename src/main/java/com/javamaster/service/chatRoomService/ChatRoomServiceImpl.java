package com.javamaster.service.chatRoomService;


import com.javamaster.model.ChatRoom;
import com.javamaster.model.User;
import com.javamaster.repository.ChatRoomRepository;
import com.javamaster.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private ChatRoomRepository chatRoomRepository;

    private UserService userService;

    @Autowired
    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository, UserService userService) {
        this.chatRoomRepository = chatRoomRepository;
        this.userService = userService;
    }

    @Override
    public Set<ChatRoom> getUsersChatRoom(Long userId) {
        User user = userService.findById(userId);
        if(user == null){
            throw new RuntimeException("User is not found"+ userId);
        }
        Set<ChatRoom> chatRooms = user.getChatRooms();


        return chatRooms;
    }

    @Override
    public ChatRoom findById( Long ChatRoomId) {
       return chatRoomRepository.findById(ChatRoomId).get();

    }

    @Override
    public void save(ChatRoom theChatRoom) {
        chatRoomRepository.save(theChatRoom);
    }

    @Override
    public void deleteById(Long theId) {
        chatRoomRepository.deleteById(theId);
    }
}
