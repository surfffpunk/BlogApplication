package com.surfpunk.blog.controllers;

import com.surfpunk.blog.models.Post;
import com.surfpunk.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class
BlogController {
    @Autowired
    private PostRepository postRepository;
    @GetMapping("/blog")
    public String blogMain(Model model){
        model.addAttribute("title", "Страница блога");
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        model.addAttribute("title", "Страница блога");
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String post_title,@RequestParam String post_anons,@RequestParam String post_text, Model model){
       Post post = new Post(post_title, post_anons, post_text);
       postRepository.save(post);
       return "redirect:/blog";
    }
    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") Integer id, Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/blog";

        }
        Optional<Post> post = postRepository.findAllById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res :: add);
        model.addAttribute("post", res);
        return "blog-details";
    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") Integer id, Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/blog";

        }
        Optional<Post> post = postRepository.findAllById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res :: add);
        model.addAttribute("post", res);
        return "blog-edit";
    }
    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") Integer id,@RequestParam String post_title,@RequestParam String post_anons,@RequestParam String post_text, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setPost_title(post_title);
        post.setPost_anons(post_anons);
        post.setPost_text(post_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @GetMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") Integer id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }
}

