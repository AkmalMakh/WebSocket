package com.javamaster.service.chatRoomService;


import com.javamaster.model.ChatRoom;


import java.util.Set;

public interface ChatRoomService {
    Set<ChatRoom> getUsersChatRoom(Long userId);

    ChatRoom findById(Long ChatRoomId);

    void save (ChatRoom theChatRoom);

    void deleteById(Long theId);
}
