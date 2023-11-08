package com.surfpunk.blog.repo;

import com.surfpunk.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    Optional<Post> findAllById(Integer id);
}
