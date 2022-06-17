package com.example.auth.accessingdatajpa;

import java.util.ArrayList;
import java.util.Optional;

import com.example.auth.accessingdatajpa.UserEntity;

public interface IUserService {

    public Iterable<UserEntity> getAll();

    public Optional<UserEntity> getById( long id);

    public UserEntity create(UserEntity UserEntity);

    public Optional<UserEntity> update(long id, UserEntity UserEntity);

    public boolean delete( long id);



}