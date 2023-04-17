package com.example.springbootnewarchitecture.controller;

import com.example.springbootnewarchitecture.dto.TestDAO;
import com.example.springbootnewarchitecture.entity.TestEntity;
import com.example.springbootnewarchitecture.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
