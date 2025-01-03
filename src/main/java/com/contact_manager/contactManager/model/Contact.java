package com.contact_manager.contactManager.model;

import com.contact_manager.contactManager.entity.ContactEntity;

public class Contact {

    private Long id;
    private String contact_name;
    private String number;
    private String description;

    public static Contact toModel(ContactEntity contact) {
        Contact model = new Contact();
        model.setId(contact.getId());
        model.setContact_name(contact.getContact_name());
        model.setNumber(contact.getNumber());
        model.setDescription(contact.getDescription());
        return model;
    }

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
