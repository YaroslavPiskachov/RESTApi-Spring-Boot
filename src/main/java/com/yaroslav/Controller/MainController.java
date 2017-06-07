package com.yaroslav.Controller;

import com.yaroslav.model.User;
import com.yaroslav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"},value = "/get")
    public List<User> getUserByName(@RequestParam(value="name") String name) {
        return userService.findUserByName(name);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public User createUser( @RequestBody User user) {
        return userService.addUser(user.getName(),user.getPhone());
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update")
    public User updateUser( @RequestBody User user) {
        return userService.updateUser(user.getId(),user.getName(),user.getPhone());
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
