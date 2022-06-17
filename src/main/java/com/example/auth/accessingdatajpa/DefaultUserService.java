package com.example.auth.accessingdatajpa;

import java.util.Optional;

import org.apache.catalina.User;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.stereotype.Service;

@Service("mainUserService")
public class DefaultUserService implements IUserService{

private UserRepository userRepository;

    @Override
    public Iterable<UserEntity> getAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getById(long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }

    @Override
    public UserEntity create(UserEntity UserEntity) {
        // TODO Auto-generated method stub
        return userRepository.save(UserEntity);
    }

    @Override
    public Optional<UserEntity> update(long id, UserEntity UserEntity) {
        // TODO Auto-generated method stub
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if(foundUser.isEmpty()){
            return Optional.empty();
        }
        foundUser.get().setId(id);
        userRepository.save(foundUser.get());
        return foundUser;
    }

    @Override
    public boolean delete(long id) {
        // TODO Auto-generated method stub
        Optional<UserEntity> foundUser= userRepository.findById(id);
        if(foundUser.isEmpty()){
            return false;
        }
        userRepository.delete(foundUser.get());
        return true;
    }

    
}