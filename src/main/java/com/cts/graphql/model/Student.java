package com.cts.graphql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Student {
    @Id
    private String studentId;
    private String studentName;
    private String address;
    private String department;
    private String gender;
    private String phoneNumber;

    public Student(String studentName, String address, String department, String gender, String phoneNumber) {
        this.studentName=studentName;
        this.address=address;
        this.department=department;
        this.gender=gender;
        this.phoneNumber=phoneNumber;
    }
}
