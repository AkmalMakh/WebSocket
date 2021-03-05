package com.javamaster.repository;

import com.javamaster.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Long> {

}
