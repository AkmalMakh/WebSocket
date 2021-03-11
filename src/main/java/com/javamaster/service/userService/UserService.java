package com.javamaster.service.userService;

import com.javamaster.model.User;

import java.util.Set;

public interface UserService {

    Set<User> getUsers();

    User findById(Long theId);

    void save (User theUser);

    void deleteById(Long theId);

    User addUserToContacts(Long userId, Long contactId);

}
