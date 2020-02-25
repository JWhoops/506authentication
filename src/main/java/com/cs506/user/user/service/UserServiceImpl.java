package com.cs506.user.user.service;

import com.cs506.user.user.dao.UserRepository;
import com.cs506.user.user.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User findByUserName(String userName) {
        // TODO
        // what if user doesn't exist?
        return userRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public User saveUser(String userJSON) {
        // TODO
        // validation? check json style?
        // what if user is not save?

        // parse JSON and convert it to User Obj
        ObjectMapper mapper = new ObjectMapper();
        try {
            User user = mapper.readValue(userJSON, User.class);
            return userRepository.save(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        // TODO
        return userRepository.findAll();
    }

    @Override
    public void deleteByUserName(String userName) {
        // TODO
        // what if delete fail or user doesn't exist?
        userRepository.deleteByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        // TODO 查重 email, username
        return userRepository.save(user);
    }
}
