package com.cs506.user.user.service;

import com.cs506.user.user.entity.User;

import java.util.List;

public interface UserService {
    public User findByUserName(String userName);

    public User saveUser(String userJSON);

    public List<User> findAll();

    public void deleteByUserName(String userName);

    public User saveUser(User user);
}
