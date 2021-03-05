package com.javamaster.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<UserContact>userContacts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chatroom")
    private Set<ChatRoom>chatRooms;

    private String userId;

    private String passwaord;

    private String userProfilePicture;

    private String createdAt;

    private boolean isActive;

    public User() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<UserContact> getUserContacts() {
        return userContacts;
    }

    public void setUserContacts(Set<UserContact> userContacts) {
        this.userContacts = userContacts;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswaord() {
        return passwaord;
    }

    public void setPasswaord(String passwaord) {
        this.passwaord = passwaord;
    }

    public String getUserProfilePicture() {
        return userProfilePicture;
    }

    public void setUserProfilePicture(String userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
