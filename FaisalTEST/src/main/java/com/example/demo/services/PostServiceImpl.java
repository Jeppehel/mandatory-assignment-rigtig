package com.example.demo.services;

import com.example.demo.Entities.Post;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;

public class PostServiceImpl implements PostService {

    ArrayList<Post> posts;

    public PostServiceImpl() {
        posts = new ArrayList<Post>();
        posts.add(new Post("hey","hey"));
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }



    @Override
    public ArrayList<Post> readPosts() {
        return posts;
    }


}
