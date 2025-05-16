package com.ducnh.shopqa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducnh.shopqa.entity.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    
}
