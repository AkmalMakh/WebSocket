package com.javamaster.repository;

import com.javamaster.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage,Long> {

}
