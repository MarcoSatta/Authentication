package com.example.auth.accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserEntity {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;

  public void setId(Long id) {
    this.id = id;
  }

  public void setusername(String username) {
    this.username = username;
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

  public void setpassword(String password) {
    this.password = password;
}
}
