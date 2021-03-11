package com.javamaster.service.contactsService;


import com.javamaster.model.UserContact;


import java.util.Set;


public interface ContactService {
    Set<UserContact> getUsersAllContacts(Long userId);

    UserContact findById(Long theId);

    void save (UserContact theUserContact);

    void deleteById(Long theId);


}
