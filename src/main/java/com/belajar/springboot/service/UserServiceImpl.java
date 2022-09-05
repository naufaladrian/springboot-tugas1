package com.belajar.springboot.service;

import com.belajar.springboot.model.User;
import com.belajar.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Integer id, User user) {
        User updateDataUser=userRepository.findById(id).get();
        updateDataUser.setUserName(user.getUserName());
        updateDataUser.setPassword(user.getPassword());
        updateDataUser.setFullName(user.getFullName());
        updateDataUser.setAge(user.getAge());
        updateDataUser.setAddress(user.getAddress());
        return userRepository.save(updateDataUser);
    }

    @Override
    public Map<String, Boolean> deleteUser(Integer id) {
        User updateDataUser=userRepository.findById(id).get();
        userRepository.delete(updateDataUser);
        Map<String, Boolean> response =new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
