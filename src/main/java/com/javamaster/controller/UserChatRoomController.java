package com.javamaster.controller;

import com.javamaster.model.ChatRoom;
import com.javamaster.model.User;
import com.javamaster.service.chatRoomService.ChatRoomService;
import com.javamaster.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserChatRoomController {

    private ChatRoomService chatRoomService;
    private UserService userService;

    @Autowired
    public UserChatRoomController(ChatRoomService chatRoomService, UserService userService) {
        this.chatRoomService = chatRoomService;
        this.userService = userService;
    }

    @GetMapping("users/{userId}/chatrooms")
        public Iterable<ChatRoom> findUserChatRooms(@PathVariable Long userId) {

        return chatRoomService.getUsersChatRoom(userId);
    }

    @GetMapping("users/chatrooms/{chatroomId}")
    public ChatRoom findUserSingleChatRoom(@PathVariable Long chatroomId)
    {
        return chatRoomService.findById(chatroomId);
    }


    @PostMapping("users/{usersId}/chatrooms")
    public ChatRoom addChatRoomtoUser(@PathVariable final Long usersId,
                                      @RequestBody ChatRoom theChatRoom)
    {
        User user = userService.findById(usersId);
        if(user == null){
            throw new RuntimeException("User id not found - "+ usersId);
        }
        user.addChatRoom(theChatRoom);
        userService.save(user);
        chatRoomService.save(theChatRoom);

        return theChatRoom;
    }

    @DeleteMapping("users/{usersId}/chatrooms/{chatroomId}")
    public String deleteChatRoomFromUser(@PathVariable final Long usersId,
                                         @PathVariable final  Long chatroomId){
        User user = userService.findById(usersId);
        if(user == null){
            throw new RuntimeException("User id not found - "+ usersId);
        }
        ChatRoom chatRoom = chatRoomService.findById(chatroomId);
        user.deleteChatRoom(chatRoom);
        chatRoomService.deleteById(chatroomId);

        return "Deleted chat Room" +chatroomId+ "of user "+ usersId;
    }
}
