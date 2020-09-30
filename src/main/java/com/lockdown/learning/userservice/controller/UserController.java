package com.lockdown.learning.userservice.controller;

import com.lockdown.learning.userservice.model.User;
import com.lockdown.learning.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity create(@RequestBody User rawData){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rawData));
    }

    @PostMapping("/add-all")
    @ResponseBody
    public ResponseEntity create(@RequestBody List<User> rawData){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAll(rawData));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity find(@PathVariable String id){
        log.info("userId:"+id);
        User user = service.findById(id);
        if(null != user){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
    }

    @GetMapping("/count")
    @ResponseBody
    public int count(@PathVariable String id){
        return service.size();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public User delete(@PathVariable String id){
        log.info("userId:"+id);
        User newUSer = service.deleteById(id);
        return newUSer;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity update(User updatedData){
        log.info("userId:"+updatedData.getId());
        User existing = service.findById(updatedData.getId());
        if(null != existing){
            return ResponseEntity.status(HttpStatus.OK).body(service.update(updatedData));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
    }

    @GetMapping("/find")
    @ResponseBody
    public List<User> findByName(@RequestParam(name="name", required = false) String name, @RequestParam(name="email", required = false) String email){
        if(null == name && null == email){
            return service.findAll();
        }else if(null == name && null != email){
            return service.findByEmail(email);
        }else if(null != name && null == email){
            return service.findByName(name);
        }else{
            return service.findByEmailAndName(email, name);
        }
    }
}
