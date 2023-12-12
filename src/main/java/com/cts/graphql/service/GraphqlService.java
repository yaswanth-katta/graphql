package com.cts.graphql.service;

import com.cts.graphql.exception.NoRecordFoundException;
import com.cts.graphql.model.GenerateId;
import com.cts.graphql.model.Student;
import com.cts.graphql.model.StudentDao;
import com.cts.graphql.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service @Slf4j
public class GraphqlService {
    @Autowired
    private StudentRepo repo;

    public Student addStudent(StudentDao studentDao){
        Student student=new Student(studentDao.getStudentName(), studentDao.getAddress(), studentDao.getDepartment(), studentDao.getGender(), studentDao.getPhoneNumber());
        student.setStudentId(GenerateId.generateStudentId());
        return repo.save(student);
    }

    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    public Student getStudentById(String studentId) throws NoRecordFoundException {
        return repo.findById(studentId).orElseThrow(()->new NoRecordFoundException("No Record is found"));

    }

    public Student updateStudentData(String studentId,StudentDao studentDao) throws NoRecordFoundException {
        Student student=repo.findById(studentId)
                .orElseThrow(()-> new NoRecordFoundException("Record is not exist with id : "+studentId));
        log.info("Updating the student details wit new data");
        BeanUtils.copyProperties(studentDao,student);

        return repo.save(student);
    }

    public String deleteStudentData(String studentId) throws NoRecordFoundException {
        repo.findById(studentId).orElseThrow(()->new NoRecordFoundException("Record is not exist with id : "+studentId));
        repo.deleteById(studentId);
        return "Successfully deleted the record";
    }
}
