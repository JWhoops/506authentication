package com.cs506.user.user.controller;

import com.cs506.user.user.entity.User;
import com.cs506.user.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // get user based on userName
    @GetMapping(value = "")
    @ResponseBody
    public User getByUserName(@RequestParam("userName") String userName) {
        User usr = userService.findByUserName(userName);
        if (usr == null) {
            return null; // user does not exist
        } else {
            return usr;
        }
    }

    @GetMapping(value = "all")
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> users = userService.findAll();
        return users;
    }

    @DeleteMapping(value = "")
    @ResponseBody
    public User deleteUser(@RequestParam("userName") String userName) {
        userService.deleteByUserName(userName);
        return null;
    }

    @PostMapping("")
    @ResponseBody
    public User insertUser(@RequestBody String userJSON) {
        return userService.saveUser(userJSON);
    }

    @PutMapping("")
    @ResponseBody
    public User insertUser(@RequestBody User user) {
        userService.deleteByUserName(user.getUserName());
        userService.saveUser(user);
        return null;
    }
}
