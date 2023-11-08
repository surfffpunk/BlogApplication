package com.surfpunk.blog.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String post_title;

    private String post_text;

    private String post_anons;

    private Integer post_views;

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public Post(String post_title, String post_text, String post_anons) {
        this.post_title = post_title;
        this.post_text = post_text;
        this.post_anons = post_anons;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public String getPost_anons() {
        return post_anons;
    }

    public void setPost_anons(String post_anons) {
        this.post_anons = post_anons;
    }

    public Integer getPost_views() {
        return post_views;
    }

    public void setPost_views(Integer post_views) {
        this.post_views = post_views;
    }
}