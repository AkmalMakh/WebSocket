package com.javamaster.repository;


import com.javamaster.model.UserContact;
import org.springframework.data.repository.CrudRepository;



public interface ContactsRepository extends CrudRepository<UserContact, Long> {

}
