package com.brytask.controller;

import com.brytask.model.User;
import com.brytask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  // GET all users
  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.findAllUsers();
    return ResponseEntity.ok(users);
  }

  // GET user by ID
  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    return userService.findUserById(id)
        .map(user -> ResponseEntity.ok(user))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // POST create a new user
  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userService.saveOrUpdateUser(user);
    return ResponseEntity.ok(savedUser);
  }

  // PUT update user
  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    return userService.findUserById(id)
        .map(existingUser -> {
          user.setId(id);
          User updatedUser = userService.saveOrUpdateUser(user);
          return ResponseEntity.ok(updatedUser);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // DELETE remove a user
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    return userService.findUserById(id)
        .map(user -> {
          userService.deleteUser(id);
          return ResponseEntity.ok().<Void>build();
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
