package com.example.springbootnewarchitecture.controller;

import com.example.springbootnewarchitecture.dto.TestDAO;
import com.example.springbootnewarchitecture.entity.TestEntity;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
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

    @GetMapping(path = "/getAllUsers")
    public List<TestEntity> getAllUsers(){
        return this.testDAO.getAllUsers();
    }

    @GetMapping(path = "/getAllUsersNativeQuery")
    public List<TestEntity> getAllUsersNativeQuery(){
        return testDAO.getAllUsersNativeQuery();
    }
    @GetMapping(path = "/find-user")
    public Optional<String> getUserById(@RequestParam Integer id) {
        return testDAO.getUserById(id).map(TestEntity::getUsername);
    }

    @DeleteMapping(path = "/user/{id}")
    public Object deleteUserById(@PathVariable Integer id){
        return testDAO.deleteUserById(id);
    }

    @GetMapping(path="/getUserById")
    public TestEntity customGetUserById(@RequestParam Integer id) {
        return testDAO.customGetUserById(id);
    }

    @PostMapping(path = "save-user")
    public TestEntity saveUser(@RequestBody TestEntity user){
        return testDAO.saveUser(user);
    }

    @PostMapping(path = "/update-user")
    public TestEntity updateUser(@RequestBody TestEntity user){
        return testDAO.updateUser(user);
    }

    @PostMapping(path = "/resetPassword")
    public void resetPassword(@RequestBody TestEntity user){
        testDAO.resetPassword(user.getPassword(), user.getId());
    }

    @DeleteMapping(path = "deleteUserById")
    public void customDeleteUserById(@RequestParam Integer id){
        testDAO.customDeleteUserById(id);
    }

}
