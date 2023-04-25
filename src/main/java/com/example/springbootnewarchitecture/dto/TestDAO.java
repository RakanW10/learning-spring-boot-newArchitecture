package com.example.springbootnewarchitecture.dto;

import com.example.springbootnewarchitecture.entity.TestEntity;
import com.example.springbootnewarchitecture.repository.TestRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        return testRepo.findAll();
    }

    public Optional<TestEntity> getUserById(Integer id){
        return testRepo.findById(id);
    }

    public Object deleteUserById(Integer id){
        Optional<TestEntity> tempUser = testRepo.findById(id);
        if(tempUser.isPresent()) {
            testRepo.deleteById(id);
            return tempUser;
        }
        else {
            HashMap<String,Object> result =new HashMap();
            result.put("Result","user not found");
            return result;
        }
    }

    public TestEntity saveUser(TestEntity user){
        return testRepo.save(user);
    }

    public TestEntity updateUser(TestEntity user){
        Optional<TestEntity> tempUser = this.getUserById(user.getId());
        if(tempUser.isPresent())
            return testRepo.save(user);
        else return null;
    }

    // Custom Queries
    public List<TestEntity> getAllUsers(){
        return this.testRepo.getAllUsers();
    }

    public TestEntity customGetUserById(Integer id){
        return testRepo.getUserById(id);
    }

    public void resetPassword(String password,Integer id){
        testRepo.resetPassword(password, id);
    }

    public void customDeleteUserById(Integer id){
        testRepo.deleteById(id);
    }

    public List<TestEntity> getAllUsersNativeQuery(){
        return testRepo.getAllUsersNativeQuery();
    }

}
