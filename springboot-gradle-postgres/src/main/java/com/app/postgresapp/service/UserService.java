package com.app.postgresapp.service;

import com.app.postgresapp.domain.User;
import com.app.postgresapp.exceptionHandler.DataNotFoundException;
import com.app.postgresapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterface{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = this.userRepository.findAll();
        return userList.stream().toList();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }

        throw new DataNotFoundException();
    }

    @Override
    public User addNewUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmailAddress(user.getEmailAddress());
        newUser.setExperience(user.getExperience());

        return this.userRepository.saveAndFlush(newUser);
    }

    @Override
    public User updateExistingUser(long id, User modifiedUserInfo) {
        User user = this.getUserById(id);
        user.setExperience(modifiedUserInfo.getExperience());
        user.setEmailAddress(modifiedUserInfo.getEmailAddress());
        user.setName(modifiedUserInfo.getName());

        return this.userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = this.getUserById(id);
        this.userRepository.delete(user);
    }
}
