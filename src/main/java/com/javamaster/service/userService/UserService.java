package com.javamaster.service.userService;

import com.javamaster.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {

    Set<User> getUsers();

    Optional<User> findById(Long theId);

    void save (User theUser);

    void deleteById(Long theId);


}
