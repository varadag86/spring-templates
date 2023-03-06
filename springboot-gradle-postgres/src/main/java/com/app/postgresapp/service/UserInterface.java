package com.app.postgresapp.service;

import com.app.postgresapp.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserInterface {

    public List<User> getAllUsers();

    public User getUserById(long id) throws Exception;

    public User addNewUser(User user) throws IOException;

    public User updateExistingUser(long id, User modifiedUserInfo) throws Exception;

    public void deleteUser(long id) throws Exception;
}
