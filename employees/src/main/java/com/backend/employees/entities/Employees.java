package com.backend.employees.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
@Getter
@Setter
@Entity
@Table (name = "Employees", schema = "public")

public class Employees {
    @Id //Primary Key
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String email;
    private String department;
}
