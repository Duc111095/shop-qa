package com.ducnh.shopqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducnh.shopqa.entity.Comment;
import com.ducnh.shopqa.service.CommentService;

@RestController
@RequestMapping("/customer_feedbacks")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public ResponseEntity<Iterable<Comment>> getComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }
}
