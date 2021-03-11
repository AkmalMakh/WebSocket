package com.javamaster.service.userService;

import com.javamaster.model.User;
import com.javamaster.model.UserContact;
import com.javamaster.repository.ContactsRepository;
import com.javamaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ContactsRepository contactsRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ContactsRepository contactsRepository) {
        this.userRepository = userRepository;
        this.contactsRepository = contactsRepository;
    }

    @Override
    public Set<User> getUsers() {
        Set<User> UserSet = new HashSet<>();

        userRepository.findAll().iterator().forEachRemaining(UserSet::add);
        return UserSet;
    }

    @Override
    public User findById(Long theId) {

        return  userRepository.findById(theId).get();
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteById(Long theId) {
        userRepository.deleteById(theId);
    }

    @Override
    public User addUserToContacts(Long userId, Long contactId) {
        User user = findById(userId);
        UserContact userContact = contactsRepository.findById(contactId).get();

        user.addContact(userContact);
        userContact.setUser(user);

        return user;
    }

}
