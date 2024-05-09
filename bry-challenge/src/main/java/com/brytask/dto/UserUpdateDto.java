package com.brytask.dto;

public class UserUpdateDto {
  private String name;
  private String photo;

  // Constructors
  public UserUpdateDto() {
  }

  public UserUpdateDto(String name, String photo) {
    this.name = name;
    this.photo = photo;
  }

  // Getters and setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

}
