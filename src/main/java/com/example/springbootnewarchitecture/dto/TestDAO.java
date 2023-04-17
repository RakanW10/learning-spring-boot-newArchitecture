package com.example.springbootnewarchitecture.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class TestDAO {
    public String Test(){
        return  "API is working - TestDAO";
    }
}
