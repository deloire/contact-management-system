package com.contact_manager.contactManager.controller;


import com.contact_manager.contactManager.entity.ContactEntity;
import com.contact_manager.contactManager.model.Contact;
import com.contact_manager.contactManager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{username}/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping
    public ResponseEntity createContact(@RequestBody ContactEntity contact, @PathVariable String username) {
        try {
            contactService.createContact(contact, username);
            return ResponseEntity.ok("Контакт успешно сохранен!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getAllContacts(@PathVariable String username) {
        try {
            List<Contact> contacts = contactService.getAllContacts(username);
            return ResponseEntity.ok(contacts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateContact(@PathVariable Long id, @RequestBody ContactEntity updateContact) {
        try {
            contactService.updateContact(id, updateContact);
            return ResponseEntity.ok("Информация о пользователе успешно обновлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContact(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(contactService.deleteContact(id));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
