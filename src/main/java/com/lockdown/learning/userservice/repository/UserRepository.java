package com.lockdown.learning.userservice.repository;

import com.lockdown.learning.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    @Query("{ 'name' : ?0 }")
    List<User> findByName(String name);

    @Query("{ 'email' : ?0 }")
    List<User> findByEmail(String email);

    @Query("{ 'email' : ?0, 'name' : ?0 }")
    List<User> findByEmailAndName(String email, String name);
}
