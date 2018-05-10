package com.example.demo.controllers;

import com.example.demo.Entities.Post;
import com.example.demo.domains.MyUser;
import com.example.demo.services.PostService;
import com.example.demo.services.PostServiceImpl;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class.getName());
    private PostServiceImpl postServiceimpl = new PostServiceImpl();

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"","/","index"}, method = RequestMethod.GET)
    public String index(){
        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("admin"))){
                return "redirect:/homeAdmin";
            }
            return "redirect:/home";
        }
    @RequestMapping (value = "/admin/postBlogPost", method = RequestMethod.POST)
    public String postBlog(@ModelAttribute Post post, Model model){
        postServiceimpl.addPost(post);
        return "redirect:/homeAdmin";
    }

    @GetMapping(value = "/homeAdmin")
    public String homeAdmin(@ModelAttribute Post posts, Model model){
        model.addAttribute("posts",postServiceimpl.readPosts());
        return "homeAdmin";
    }
    @GetMapping(value = "/BlogAdmin")
    public String BlogAdmin(Model model){
        model.addAttribute("post",new Post());
        return "BlogAdmin";
    }
    @PostMapping(value = "/BlogAdmin")
    public String BlogAdmin(@ModelAttribute Post post){
        postService.addPost(post);
        return "redirect:/homeAdmin";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Admin(@ModelAttribute Post posts, Model model){
        model.addAttribute("posts",postServiceimpl.readPosts());
        return "home";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "logout";
    }

    private PostService postService;


}
