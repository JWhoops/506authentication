package com.cs506.user.user;

import com.cs506.user.user.dao.UserRepository;
import com.cs506.user.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    public void run(String... args) throws Exception {
        // clean DB first for testing
        // userRepository.deleteAll();
//
//        // create user
//        User usr1 = new User("shu", "hu", "9080158893",
//                "shuhu@wisc.edu", "aa123", "aaaaa");
//        User usr2 = new User("hehe", "haha", "9080158893",
//                "shuhu@wisc.edu", "aa123", "aaaaa");
//        // save usr
//        userRepository.save(usr1);
//        userRepository.save(usr2);
    }
}
