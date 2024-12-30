package com.contact_manager.contactManager.controller;


import com.contact_manager.contactManager.entity.UserEntity;
import com.contact_manager.contactManager.exceptions.UserAlreadyExistException;
import com.contact_manager.contactManager.exceptions.UserNotFoundException;
import com.contact_manager.contactManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return  ResponseEntity.ok("User saved!");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity getOneUser(@PathVariable String username) {
        try {
            return ResponseEntity.ok(userService.getOneUser(username));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

}
