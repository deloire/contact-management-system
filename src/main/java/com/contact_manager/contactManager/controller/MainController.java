package com.contact_manager.contactManager.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public ResponseEntity mainPage() {
        try {
            return ResponseEntity.ok("App is working!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Some problems!");
        }
    }

}
