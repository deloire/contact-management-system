package com.contact_manager.contactManager.service;


import com.contact_manager.contactManager.entity.ContactEntity;
import com.contact_manager.contactManager.entity.UserEntity;
import com.contact_manager.contactManager.exceptions.UserNotFoundException;
import com.contact_manager.contactManager.model.Contact;
import com.contact_manager.contactManager.repository.ContactRepo;
import com.contact_manager.contactManager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Contact> getAllContacts(String username) throws UserNotFoundException {

        UserEntity user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        }

        List<ContactEntity> contacts = contactRepo.findByUser(user);
        List<Contact> contactList = new ArrayList<>();

        for (ContactEntity contact : contacts) {
            Contact model = Contact.toModel(contact);
            contactList.add(model);
        }
        return contactList;
    }

    public String deleteContact(Long id) {
        contactRepo.deleteById(id);
        return "Контакт успешно удален!";
    }

    public Contact updateContact(Long id, ContactEntity contact) {

        ContactEntity existingContact = contactRepo.findById(id).get();

        existingContact.setContact_name(contact.getContact_name());
        existingContact.setNumber(contact.getNumber());
        existingContact.setDescription(contact.getDescription());

        return Contact.toModel(contactRepo.save(existingContact));

    }

}
