package com.belajar.springboot.controller;

import com.belajar.springboot.dto.LoginDTO;
import com.belajar.springboot.dto.UserDTO;
import com.belajar.springboot.model.TemporaryToken;
import com.belajar.springboot.model.User;
import com.belajar.springboot.response.CommonResponse;
import com.belajar.springboot.response.CommonResponseGenerator;
import com.belajar.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResponse<TemporaryToken> login(@RequestBody LoginDTO loginDTO){
        return CommonResponseGenerator.successResponse(userService.login(loginDTO));
    }

    @PostMapping("/register")
    public CommonResponse<User> register(@RequestBody UserDTO userDTO){
        return CommonResponseGenerator.successResponse(userService.register(userDTO));
    }
}
