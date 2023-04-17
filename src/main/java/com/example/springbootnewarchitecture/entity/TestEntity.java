package com.example.springbootnewarchitecture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private  Integer userId;

    // no need for @Column if the attribute's name same as the attribute at the database
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="full_name")
    private String fullName;
    @Column(name="created_date")
    private String createdDate;


}
