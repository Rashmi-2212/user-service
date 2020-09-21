package com.lockdown.learning.userservice.controller;

import com.lockdown.learning.userservice.model.User;
import com.lockdown.learning.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repo;

    public UserController(UserRepository repo){
        this.repo = repo;
    }

    @PostMapping("/new")
    @ResponseBody
    public User create(@RequestBody User rawData){
        rawData.setId(ObjectId.get().toString());
        User newUSer = repo.save(rawData);
        log.debug(newUSer.getId());
        return find(newUSer.getId());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User find(@PathVariable String id){
        log.info("userId:"+id);
        User newUSer = repo.findById(id).get();
        return newUSer;
    }

    @GetMapping
    @ResponseBody
    public User findAll(){
    return null;
    }

}
