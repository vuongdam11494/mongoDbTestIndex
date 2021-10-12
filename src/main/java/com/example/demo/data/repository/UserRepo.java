package com.example.demo.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.data.model.User;

public interface UserRepo extends MongoRepository<User, String>{

}
