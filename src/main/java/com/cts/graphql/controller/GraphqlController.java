package com.cts.graphql.controller;

import com.cts.graphql.exception.NoRecordFoundException;
import com.cts.graphql.model.Student;
import com.cts.graphql.model.StudentDao;
import com.cts.graphql.service.GraphqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GraphqlController {
    @Autowired
    private GraphqlService service;

/**    @PostMapping(value = "/addStudent")
    public Student addStudent(@RequestBody StudentDao studentDao){
        return service.addStudent(studentDao);
    }

    @GetMapping(value = "/studentById/{studentId}")
    public Student StudentById(@PathVariable String studentId) throws NoRecordFoundException {
        return service.getStudentById(studentId);
    }*/

    @QueryMapping
    List<Student> allStudents(){
        return service.getAllStudents();
    }

    @QueryMapping
    Student getStudentById(@Argument String studentId) throws NoRecordFoundException {
        return service.getStudentById(studentId);
    }

    @MutationMapping
    Student addStudentData(@Argument StudentDao studentDao){
        return service.addStudent(studentDao);
    }

    @MutationMapping
    String deleteStudentData(@Argument String studentId) throws NoRecordFoundException {
        return service.deleteStudentData(studentId);
    }

    @MutationMapping
    Student updateStudentData(@Argument String studentId,@Argument StudentDao studentDao) throws NoRecordFoundException {
        return service.updateStudentData(studentId,studentDao);
    }

}
