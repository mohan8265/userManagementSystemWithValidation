package com.geekster.UserManagement.controller;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/addUser")
    public String addUser(@Valid @RequestBody User user){
        return userService.addNewUser(user);
    }

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/getUser/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PutMapping(value = "/updateUserInfo/{userId}")
    public String updateUserInfo(@PathVariable String userId, @Valid @RequestBody User user){
        return userService.updateUser(userId,user);
    }

    @DeleteMapping(value = "/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId){
        return userService.deleteUserById(userId);
    }


}
