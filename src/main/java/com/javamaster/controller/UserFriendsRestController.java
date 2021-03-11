package com.javamaster.controller;



import com.javamaster.model.User;
import com.javamaster.model.UserContact;
import com.javamaster.service.contactsService.ContactService;
import com.javamaster.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api")
public class UserFriendsRestController {

    private ContactService contactService;
    private UserService userService;

    @Autowired
    public UserFriendsRestController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

    @GetMapping("users/{userId}/contacts")
    public Iterable<UserContact> findUsersAllContacts(@PathVariable Long userId){

        return contactService.getUsersAllContacts(userId);
    }

    @GetMapping("users/contacts/{contactId}")
    public UserContact getSingleUserSingleContact(@PathVariable Long contactId
                                             ){
        UserContact userContact = contactService.findById(contactId);

        if(userContact == null){
            throw new RuntimeException("User id not found - "+ contactId);
        }
        return contactService.findById(contactId);
    }


    @PostMapping( "users/{usersId}/contacts")
    public UserContact addContactToUser(@PathVariable final Long usersId,
                                        @RequestBody UserContact theUserContact){
        User user  = userService.findById(usersId);

        user.addContact(theUserContact);
        userService.save(user);
        contactService.save(theUserContact);


        return theUserContact;
    }


    @DeleteMapping("users/{usersId}/contacts/{contactId}")
    public String deleteContactFromUser(@PathVariable final Long usersId,
                                        @PathVariable final Long contactId){
        User user = userService.findById(usersId);

        UserContact userContact = contactService.findById(contactId);
        user.deleteContact(userContact);
        contactService.deleteById(contactId);
        return "Deleted contact" +contactId+" from user "+ usersId;
    }



}
