package com.example.employ;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;//jakarta j2e me 
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emp_db")
public class EmployeeEntity {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;
    private String name;
    private String phone;
    private String email;
}
