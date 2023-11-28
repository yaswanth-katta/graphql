package com.cts.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class StudentDao {
    private String studentName;
    private String address;
    private String department;
    private String gender;
    private String phoneNumber;
}
