package com.javamaster.repository;

import com.javamaster.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<ChatMessage, Long> {

}