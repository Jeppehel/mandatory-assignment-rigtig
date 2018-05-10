package com.example.demo.services;

import com.example.demo.domains.MyUser;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public MyUser getUser(String username, String password){
        MyUser user = new MyUser();
        user.setId(1l);
        user.setUsername("test");
        user.setPassword("test");
        user.setRoles("user");
        MyUser admin = new MyUser();
        admin.setId(2l);
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRoles("admin");



        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            return user;
        }
        else if (admin.getUsername().equals(username) && admin.getPassword().equals(password)){
            return admin;
        }


        return null;
    }

}
