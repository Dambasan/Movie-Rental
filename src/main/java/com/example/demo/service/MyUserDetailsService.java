package com.example.demo.service;

import com.example.demo.MyUserPrincipal;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfo userInfo;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        userInfo.setEmail(user.getEmail());
        userInfo.setName(user.getName());
        userInfo.setSurname(user.getSurname());
        return new MyUserPrincipal(user);
    }
}