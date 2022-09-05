package com.belajar.springboot.controller;


import com.belajar.springboot.model.User;
import com.belajar.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public  User findById(@PathVariable("id") Integer id){
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAllUser();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id")Integer id, @RequestBody User user){
        return userService.updateUser(id , user);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean>deleteCar(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }
}
