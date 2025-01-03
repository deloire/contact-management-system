package com.contact_manager.contactManager.service;


import com.contact_manager.contactManager.entity.ContactEntity;
import com.contact_manager.contactManager.entity.UserEntity;
import com.contact_manager.contactManager.model.Contact;
import com.contact_manager.contactManager.repository.ContactRepo;
import com.contact_manager.contactManager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepo contactRepo;
    @Autowired
    UserRepo userRepo;

    public Contact createContact(ContactEntity contact, String username) {
        UserEntity user = userRepo.findByUsername(username);
        contact.setUser(user);
        return Contact.toModel(contactRepo.save(contact));
    }

}
