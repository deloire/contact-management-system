package com.contact_manager.contactManager.service;


import com.contact_manager.contactManager.entity.UserEntity;
import com.contact_manager.contactManager.exceptions.UserAlreadyExistException;
import com.contact_manager.contactManager.exceptions.UserNotFoundException;
import com.contact_manager.contactManager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with this name already exists!");
        }
        return userRepo.save(user);
    }

    public UserEntity getOneUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        }
        return user;
    }

    public List<UserEntity> getAllUsers() {
        Iterable<UserEntity> iterableUsers = userRepo.findAll();
        List<UserEntity> userList = new ArrayList<>();
        iterableUsers.forEach(userList::add);
        return userList;
    }

    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "User deleted!";
    }

}