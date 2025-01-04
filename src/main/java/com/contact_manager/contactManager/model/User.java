package com.contact_manager.contactManager.model;

import com.contact_manager.contactManager.entity.UserEntity;

public class User {

    private Long id;
    private String username;
    private long countContacts;

    public static User toModel(UserEntity user, long countContacts) {
        User model = new User();
        model.setId(user.getId());
        model.setUsername(user.getUsername());
        model.setCountContacts(countContacts);
        return model;
    }

    public User() {
    }

    public long getCountContacts() {
        return countContacts;
    }

    public void setCountContacts(long countContacts) {
        this.countContacts = countContacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
