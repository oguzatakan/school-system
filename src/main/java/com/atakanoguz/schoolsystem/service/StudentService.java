package com.atakanoguz.schoolsystem.service;

import com.atakanoguz.schoolsystem.model.Student;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;

public interface StudentService {
    ResponseEntity getAllStudents();
    ResponseEntity getStudentById(Long id);
    ResponseEntity findAllByDepartmentId(Long id);
    ResponseEntity createStudent(Student student);
    ResponseEntity updateStudent(Student student)throws InvocationTargetException, IllegalAccessException;
    ResponseEntity deleteStudent(Student student);
    ResponseEntity deleteStudentById(Long id);

}
