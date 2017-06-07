package com.yaroslav.service.impl;

import com.yaroslav.dao.UserDao;
import com.yaroslav.model.User;
import com.yaroslav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;
    @Override
    public User findUserById(long id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> findAllUsers() {
        return (List) userDao.findAll();
    }

    @Override
    public User addUser(String name, String phone) {
        return userDao.save(new User(name,phone));
    }

    @Override
    public User updateUser(long id, String name, String phone) {
        User user=findUserById(id);
        if(phone!=null) user.setPhone(phone);
        if(name!=null)user.setName(name);
        return userDao.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.delete(id);
    }
}
