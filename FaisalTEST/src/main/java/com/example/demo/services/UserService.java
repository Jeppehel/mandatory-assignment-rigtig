package com.example.demo.services;


import com.example.demo.domains.MyUser;

public interface UserService {

    MyUser getUser(String username, String password);

}
