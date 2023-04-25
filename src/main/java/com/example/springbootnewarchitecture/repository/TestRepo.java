package com.example.springbootnewarchitecture.repository;

import com.example.springbootnewarchitecture.entity.TestEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestRepo extends JpaRepository<TestEntity, Integer> {


    // custom queries
    @Query(value = "SELECT t FROM TestEntity t")
    List<TestEntity> getAllUsers();

    @Query(value = "SELECT t FROM TestEntity t WHERE t.id =:id")
    TestEntity getUserById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE TestEntity t SET t.password=:password WHERE t.id=:id")
    void resetPassword(String password, Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TestEntity t WHERE t.id = :id")
    void deleteUserById(Integer id);



    @Query(value = "SELECT * FROM users ORDER BY user_id desc",nativeQuery = true)
    List<TestEntity> getAllUsersNativeQuery();
}
