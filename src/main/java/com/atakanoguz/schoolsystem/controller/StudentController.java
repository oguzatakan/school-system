package com.atakanoguz.schoolsystem.controller;


import com.atakanoguz.schoolsystem.model.Student;
import com.atakanoguz.schoolsystem.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/students/byDepartment/{id}")
    public ResponseEntity<List<Student>> findAllByDepartmentId(@PathVariable long id){
        return studentService.findAllByDepartmentId(id);
    }

    @PostMapping("/students/save")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/students/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student)throws InvocationTargetException,IllegalAccessException{
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/students/delete")
    public ResponseEntity<Map<String,Boolean>> deleteStudent(@RequestBody Student student){
        return studentService.deleteStudent(student);
    }

    @DeleteMapping("/students/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStudentById(@PathVariable long id){
        return studentService.deleteStudentById(id);
    }

}
