package com.atakanoguz.schoolsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ManyToOne
    private Department department;

    @Column(name="age")
    private short age;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public Student(){
    }

    public Student(Long id, String firstName, String lastName, Department studentAffairs, short age, String address, String department, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = studentAffairs;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
