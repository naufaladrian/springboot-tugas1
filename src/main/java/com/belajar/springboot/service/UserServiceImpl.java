package com.belajar.springboot.service;

import com.belajar.springboot.dto.LoginDTO;
import com.belajar.springboot.dto.UserDTO;
import com.belajar.springboot.exception.BusinessException;
import com.belajar.springboot.jwt.JwtProvider;
import com.belajar.springboot.model.TemporaryToken;
import com.belajar.springboot.model.User;
import com.belajar.springboot.repository.TemporaryTokenRepository;
import com.belajar.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;
    private UserRepository userRepository;
    private TemporaryTokenRepository temporaryTokenRepository;
    private UserDetailservice userDetailservice;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtProvider jwtProvider, UserRepository userRepository,TemporaryTokenRepository temporaryTokenRepository, UserDetailservice userDetailservice) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
        this.userDetailservice = userDetailservice;
        this.temporaryTokenRepository=temporaryTokenRepository;
    }

    @Override
    public User register(UserDTO userDTO) {
        try {
            User user = new User();
            user.setUserName(userDTO.getUsername());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setAddress(userDTO.getAddress());
            user.setUserStatus(userDTO.getUserStatus());
            user.setAge(userDTO.getAge());
            user.setAddress(user.getAddress());
            user.setAge(userDTO.getAge());
            user.setFullName(userDTO.getFullName());
            return userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new BusinessException("Username Already Exist");
        }
    }

    @Transactional
    @Override
    public TemporaryToken login(LoginDTO loginDTO) {
        try {
          Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
            UserDetails userDetails = userDetailservice.loadUserByUsername(loginDTO.getUsername());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateJwtToken(authentication);
            User user=userRepository.findByUsername(userDetails.getUsername()).get();
            var tokenAlready=temporaryTokenRepository.findByUserId(user);
            if (tokenAlready.isPresent()){
                temporaryTokenRepository.delete(tokenAlready.get());
            }
            TemporaryToken temporaryToken=new TemporaryToken();
            temporaryToken.setToken(jwt);
            temporaryToken.setExpiredDate(new Date(System.currentTimeMillis()+900000));
            temporaryToken.setUserId(user);
            return temporaryTokenRepository.save(temporaryToken);
        } catch (BadCredentialsException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


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
        User updateDataUser = userRepository.findById(id).get();
        updateDataUser.setUserName(user.getUserName());
        updateDataUser.setPassword(user.getPassword());
        updateDataUser.setFullName(user.getFullName());
        updateDataUser.setAge(user.getAge());
        updateDataUser.setAddress(user.getAddress());
        return userRepository.save(updateDataUser);
    }

    @Override
    public Map<String, Boolean> deleteUser(Integer id) {
        User updateDataUser = userRepository.findById(id).get();
        userRepository.delete(updateDataUser);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
