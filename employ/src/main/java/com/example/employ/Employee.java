package com.example.employ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok se getters, setters, constructors auto generate ho jayenge
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id; // Employee ID
    private String name; // Employee name
    private String phone;// Employee phone
    private String email;// Employee email
}
