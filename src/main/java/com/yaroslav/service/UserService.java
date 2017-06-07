package com.yaroslav.service;

import com.yaroslav.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User findUserById(long id);
    List<User> findUserByName(String name);
    List<User> findAllUsers();
    User addUser(String name, String phone);
    User updateUser(long id,String name, String phone);
    void deleteUser(long id);
}
