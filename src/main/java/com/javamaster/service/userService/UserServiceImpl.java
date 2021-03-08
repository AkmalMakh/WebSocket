package com.javamaster.service.userService;

import com.javamaster.model.User;
import com.javamaster.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> getUsers() {
        Set<User> UserSet = new HashSet<>();

        userRepository.findAll().iterator().forEachRemaining(UserSet::add);
        return UserSet;
    }
}
