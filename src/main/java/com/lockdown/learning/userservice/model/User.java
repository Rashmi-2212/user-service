package com.lockdown.learning.userservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("users")
@Setter
@Getter
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private Address address;
    private Role role;
}
