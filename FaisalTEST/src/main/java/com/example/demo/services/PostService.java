package com.example.demo.services;

import com.example.demo.Entities.Post;
import com.example.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface PostService {

    public void addPost(Post post);

    public ArrayList<Post> readPosts();


}
