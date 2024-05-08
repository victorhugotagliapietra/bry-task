package com.brytask.service;

import com.brytask.model.User;
import com.brytask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  // Search for all Users
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  // Search an User by ID
  public Optional<User> findUserById(Long id) {
    return userRepository.findById(id);
  }

  // Save or Update User
  public User saveOrUpdateUser(User user) {
    return userRepository.save(user);
  }

  // Delete User
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

}
