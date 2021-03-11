package com.javamaster.service.contactsService;

import com.javamaster.model.User;
import com.javamaster.model.UserContact;
import com.javamaster.repository.ContactsRepository;
import com.javamaster.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactsRepository contactsRepository;

    private UserService userService;

    @Autowired
    public ContactServiceImpl(ContactsRepository contactsRepository, UserService userService) {
        this.contactsRepository = contactsRepository;
        this.userService = userService;
    }

    @Override
    public Set<UserContact> getUsersAllContacts(Long userId) {
        User user = userService.findById(userId);
        if(user == null){
            throw new RuntimeException("User is not found"+ userId);
        }
        Set<UserContact> userContacts = user.getUserContacts();

        return userContacts;
    }

    @Override
    public void save(UserContact theUserContact) {

        contactsRepository.save(theUserContact);
    }

    @Override
    public UserContact findById(Long id) {
        return contactsRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long theId) {
        contactsRepository.deleteById(theId);
    }
}
