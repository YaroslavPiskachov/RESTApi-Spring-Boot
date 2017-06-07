package com.yaroslav.dao;


import com.yaroslav.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}
