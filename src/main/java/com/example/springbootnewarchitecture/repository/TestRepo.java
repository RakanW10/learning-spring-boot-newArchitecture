package com.example.springbootnewarchitecture.repository;

import com.example.springbootnewarchitecture.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestRepo extends CrudRepository<TestEntity , Integer > {
}
