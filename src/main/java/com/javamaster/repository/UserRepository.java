package com.javamaster.repository;

import com.javamaster.model.ChatMessage;
import com.javamaster.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User,Long> {

}
