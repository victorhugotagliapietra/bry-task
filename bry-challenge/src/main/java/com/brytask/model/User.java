package com.brytask.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, unique = true, length = 20)
  private String cpf;

  @Column(nullable = false, length = 255)
  private String photo;

  /*
   * Constructors
   */
  public User() {
  }

  public User(Long id, String name, String cpf, String photo) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.photo = photo;
  }

  /*
   * Getters e Setters
   */
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
        Objects.equals(cpf, user.cpf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cpf);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", cpf='" + cpf + '\'' +
        ", photo='" + photo + '\'' +
        '}';
  }
}
