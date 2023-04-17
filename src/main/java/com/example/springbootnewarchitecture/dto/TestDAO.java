package com.example.springbootnewarchitecture.dto;

import com.example.springbootnewarchitecture.entity.TestEntity;
import com.example.springbootnewarchitecture.repository.TestRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class TestDAO {
    @Autowired
    private TestRepo testRepo;

    public String Test(){
        return  "API is working - TestDAO";
    }
    public Iterable<TestEntity> getUsers(){
        return this.testRepo.findAll();
    }

}
