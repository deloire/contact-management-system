package com.contact_manager.contactManager.controller;


import com.contact_manager.contactManager.entity.ContactEntity;
import com.contact_manager.contactManager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{username}/create-contact")
public class CreateContactController {

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



}
