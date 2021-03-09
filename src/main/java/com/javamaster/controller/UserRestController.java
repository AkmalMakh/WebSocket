package com.javamaster.controller;

import com.javamaster.model.User;
import com.javamaster.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Set<User> findAll(){
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getSingleUser(@PathVariable int userId){
        Optional<User> user = userService.findById(new Long(userId));

        if(user == null){
            throw new RuntimeException("User id not found - "+ userId);
        }
        return user;
    }

        @PostMapping("/users")
        public User addUser(@RequestBody User theUser){
            theUser.setId(0L);
            userService.save(theUser);

            return theUser;
        }

        @PutMapping("/users")
        public User updateUser(@RequestBody User theUser){
            userService.save(theUser);

            return theUser;
        }

        @DeleteMapping("users/{userId}")
    public String deleteEmployee(@PathVariable int userId){
        Optional<User> theUser = userService.findById(new Long(userId));
        if(theUser == null){
            throw new RuntimeException("User is not found"+ userId);

        }
        userService.deleteById(new Long(userId));
             return "Deleted user id - "+userId;

        }


}
