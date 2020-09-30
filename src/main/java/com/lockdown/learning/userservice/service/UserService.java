package com.lockdown.learning.userservice.service;

import com.lockdown.learning.userservice.model.User;
import com.lockdown.learning.userservice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository repository;
    private static int size;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User save(User user){
        user.setId(ObjectId.get().toString());
        User saved = repository.save(user);
        size++;
        return saved;
    }

    public List<User> saveAll(List<User> list){
        List<User> saved = new ArrayList<>();
        for ( User user : list){
            saved.add(save(user));
        }
        return saved;
    }

    public User update(User obj){
        User updated = repository.save(obj);
        return updated;
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        return repository.findById(id).get();
    }

    public List<User> findByName(String name){
        return repository.findByName(name);
    }

    public List<User> findByEmail(String email){
        return repository.findByEmail(email);
    }

    public List<User> findByEmailAndName(String email, String name){
        return repository.findByEmailAndName( email,  name);
    }

    public User deleteById(String id){
        User savedObj = findById(id);
        repository.deleteById(id);
        size--;
        return savedObj;
    }

    public boolean isNameExists(String name){
        return findByName(name).size() >= 1;
    }

    public int size(){
        return size;
    }
}
