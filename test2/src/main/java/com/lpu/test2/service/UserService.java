package com.lpu.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.test2.entity.AppUser;
import com.lpu.test2.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public AppUser createUser(AppUser user){

        user.setPassword(encoder.encode(user.getPassword()));

        return repo.save(user);
    }

}