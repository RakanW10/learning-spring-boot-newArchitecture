package com.example.springbootnewarchitecture.repository;

import com.example.springbootnewarchitecture.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<TestEntity , Integer > {
}
