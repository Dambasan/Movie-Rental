package com.example.demo.service;

import com.example.demo.controller.RegisterController;
import com.example.demo.models.RegisterForm;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(RegisterForm form){
        User user = new User();
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        return userRepository.save(user);
    }
}
