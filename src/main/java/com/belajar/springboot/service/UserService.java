package com.belajar.springboot.service;

import com.belajar.springboot.dto.LoginDTO;
import com.belajar.springboot.dto.UserDTO;
import com.belajar.springboot.model.TemporaryToken;
import com.belajar.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User register(UserDTO userDTO);
    TemporaryToken login(LoginDTO loginDTO);
    User addUser(User user);
    User getById(Integer id);
    User updateUser(Integer id, User user);
    List<User>getAllUser();
    Map<String, Boolean> deleteUser(Integer id);

}
