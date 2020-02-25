package com.cs506.user.user.dao;

import com.cs506.user.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByUserName(String userName);

    // update or save
    public User save(User user);

    public List<User> findAll();

    public void deleteByUserName(String userName);

}
