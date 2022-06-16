package com.example.auth.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<user, Long> {

  List<user> findByUsername(String username);

  user findById(long id);
}