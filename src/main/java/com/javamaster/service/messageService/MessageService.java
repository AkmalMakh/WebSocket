package com.javamaster.service.messageService;

import com.javamaster.model.ChatMessage;


import java.util.Set;

public interface MessageService {
    Set<ChatMessage> getChatRoomsAllMessages(Long chatId);

    ChatMessage findById(Long messageId);

    void save (ChatMessage message);

    void deleteMessageById(Long theId);
}
