package com.example.auth.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<user, Long> {

}