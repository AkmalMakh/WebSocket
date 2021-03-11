package com.javamaster.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH , CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.REMOVE}, mappedBy = "user")
    @JsonManagedReference
    private Set<UserContact>userContacts;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH , CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "user")
    @JsonManagedReference
    private Set<ChatRoom>chatRooms;



    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "password")
    private String passwaord;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "user_profile_picture")
    private String userProfilePicture;



    @Column(name = "is_active")
    private boolean isActive;

    public User() {

    }

    public User(Set<UserContact> userContacts, Set<ChatRoom> chatRooms, String userName, String userEmail, String passwaord, String createdAt, String userProfilePicture, boolean isActive) {
        this.userContacts = userContacts;
        this.chatRooms = chatRooms;
        this.userName = userName;
        this.userEmail = userEmail;
        this.passwaord = passwaord;
        this.createdAt = createdAt;
        this.userProfilePicture = userProfilePicture;
        this.isActive = isActive;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Set<ChatRoom> getChatRooms() {
        return chatRooms;
    }

    public void setChatRooms(Set<ChatRoom> chatRooms) {
        this.chatRooms = chatRooms;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", userContacts=" + userContacts +
                ", chatRooms=" + chatRooms +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", passwaord='" + passwaord + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", userProfilePicture='" + userProfilePicture + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public void addChatRoom(ChatRoom chatRoom){
        if(chatRoom == null){
            chatRoom   = new ChatRoom();
        }
        chatRoom.setUser(this);

    }
    public void addContact(UserContact userCont){
        if(userCont == null){
            userCont   = new UserContact();
        }
        userCont.setUser(this);

    }
    public void deleteContact(UserContact userContact){
       this.userContacts.remove(userContact);
    }
    public void deleteChatRoom(ChatRoom chatRoom){
        this.chatRooms.remove(chatRoom);
    }
}
