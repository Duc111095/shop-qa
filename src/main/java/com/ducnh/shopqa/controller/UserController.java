package com.ducnh.shopqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducnh.shopqa.entity.User;
import com.ducnh.shopqa.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User entity) {
        try {
            userService.createUser(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }           
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        try {
            userService.deleteUser(Long.parseLong(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unable to delete user");
        }
        return ResponseEntity.ok("User deleted successfully");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable String id, @RequestBody User user) {
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unable to update user");
        }           
        return ResponseEntity.ok("User updated successfully");
    }
}
