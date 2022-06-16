package com.example.auth.accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class user {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;

  protected user() {}

  public user(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public String toString() {
    return String.format(
        "user[id=%d, username='%s', password='%s']",
        id, username, password);
  }

  public Long getId() {
    return id;
  }

  public String getusername() {
    return username;
  }

  public String getpassword() {
    return password;
  }
}