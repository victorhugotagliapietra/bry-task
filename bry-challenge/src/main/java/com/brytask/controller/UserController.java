package com.brytask.controller;

import com.brytask.model.User;
import com.brytask.dto.UserUpdateDto;
import com.brytask.util.DataMaskingUtil;
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
    users.forEach(user -> user.setCpf(DataMaskingUtil.maskCpf(user.getCpf())));
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
    User savedUser = userService.saveUser(user);
    return ResponseEntity.ok(savedUser);
  }

  // PUT update user
  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
    return userService.updateUser(id, userUpdateDto)
        .map(updatedUser -> ResponseEntity.ok(updatedUser))
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
