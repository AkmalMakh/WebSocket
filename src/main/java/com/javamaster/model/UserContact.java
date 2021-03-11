package com.javamaster.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(name = "contact_id")
    private String contactId;


    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_picture")
    private String profilePicture;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    private String CreatedAt;

    public UserContact() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }



    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserContact{" +
                "Id=" + Id +
                ", user=" + user +
                ", contactId='" + contactId + '\'' +
                ", contactName='" + contactName + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", isActive=" + isActive +
                ", CreatedAt='" + CreatedAt + '\'' +
                '}';
    }
}
