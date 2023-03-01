package com.app.postgresapp.service;

import com.app.postgresapp.domain.User;
import com.app.postgresapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserInterface{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = this.userRepository.findAll();
        System.out.println(userList);
        return userList.stream().toList();
    }
}
