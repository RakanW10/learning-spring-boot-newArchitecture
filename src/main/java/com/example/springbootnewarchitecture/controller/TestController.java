package com.example.springbootnewarchitecture.controller;

import com.example.springbootnewarchitecture.dto.TestDAO;
import com.example.springbootnewarchitecture.entity.TestEntity;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private TestDAO testDAO;


    @GetMapping("/test")
    public String test(){
        return this.testDAO.Test();
    }

    @GetMapping(path = "/get-users")
    public Iterable<TestEntity> getUsers(){
        return testDAO.getUsers();
    }

    @GetMapping(path = "/find-user")
    public Optional<String> getUserById(@RequestParam Integer id) {
        return testDAO.getUserById(id).map(TestEntity::getUsername);
    }

    @DeleteMapping(path = "/user/{id}")
    public Object deleteUserById(@PathVariable Integer id){
        return testDAO.deleteUserById(id);
    }

    @PostMapping(path = "save-user")
    public TestEntity saveUser(@RequestBody TestEntity user){
        return testDAO.saveUser(user);
    }

}
