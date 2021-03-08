package com.javamaster.service.chatService;

import com.javamaster.model.ChatRoom;


import java.util.Set;

public interface ChatService {
    Set<ChatRoom> getChats();
}
