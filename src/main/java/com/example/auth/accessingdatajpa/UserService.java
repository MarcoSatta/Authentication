package com.example.auth.accessingdatajpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.auth.accessingdatajpa.UserEntity;

@Service
public class UserService implements IUserService {

    private List<UserEntity> list;
    private long lastId;

    public UserService() {

        list = new ArrayList<UserEntity>();
        lastId=0;
    }
    @Override
    public Iterable<UserEntity> getAll(){
        return list;
        }
    @Override
    public Optional<UserEntity> getById( long id) {
           Optional<UserEntity> UserEntity = list.stream().filter(item->item.getId() == id).findFirst();
           return UserEntity;
    }
    @Override
    public UserEntity create(UserEntity UserEntity) {
        lastId++;
        UserEntity.setId(lastId);
        list.add(UserEntity);
        return UserEntity;
    }
    @Override
    public Optional<UserEntity> update(long id, UserEntity UserEntity) {
        Optional<UserEntity> foundUserEntity = list.stream().filter(item->item.getId() == id).findFirst();

        if(foundUserEntity.isEmpty()) {
            return Optional.empty();
        }
        foundUserEntity.get().setId(UserEntity.getId());

        return foundUserEntity;
    }
    @Override
    public boolean delete( long id) {

        Optional<UserEntity> foundUserEntity = list.stream().filter(item->item.getId() == id).findFirst();

        if(foundUserEntity.isEmpty()) {
            return false;
            }
        list.remove(foundUserEntity.get());
        return true;

}

}