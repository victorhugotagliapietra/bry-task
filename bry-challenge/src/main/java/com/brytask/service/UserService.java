package com.brytask.service;

import com.brytask.model.User;
import com.brytask.dto.UserUpdateDto;
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

  // Update User
  public Optional<User> updateUser(Long id, UserUpdateDto userUpdateDto) {
    return userRepository.findById(id)
        .map(existingUser -> {
          existingUser.setName(userUpdateDto.getName());
          existingUser.setPhoto(userUpdateDto.getPhoto());
          return userRepository.save(existingUser);
        });
  }

  // Save User
  public User saveUser(User user) {
    if (user.getCpf() == null || user.getCpf().length() != 11) {
      throw new IllegalArgumentException("the CPF must have exactly 11 characters.");
    }
    return userRepository.save(user);
  }

  // Delete User
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

}
