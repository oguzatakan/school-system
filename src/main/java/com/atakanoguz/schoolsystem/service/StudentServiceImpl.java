package com.atakanoguz.schoolsystem.service;

import com.atakanoguz.schoolsystem.exception.NotFoundByIdException;
import com.atakanoguz.schoolsystem.model.Student;
import com.atakanoguz.schoolsystem.repository.StudentRepository;
import com.atakanoguz.schoolsystem.util.NullAwareBeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @Override
    public ResponseEntity<Student> getStudentById(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()-> new NotFoundByIdException("Student not exist with id: "+id));
        return ResponseEntity.ok(student);
    }

    @Override
    public ResponseEntity<List<Student>> findAllByDepartmentId(Long id){
        List<Student> students=studentRepository.findAllByDepartmentId(id);
        return ResponseEntity.ok(students);
    }

    @Override
    public ResponseEntity<Student> createStudent(Student student){
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @Override
    public ResponseEntity<Student> updateStudent(Student student)throws InvocationTargetException,IllegalAccessException{
        Student existingStudent=studentRepository.findById(student.getId()).orElseThrow(()-> new NotFoundByIdException("Student not exist with id:" +student.getId()));
        if (existingStudent==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        BeanUtilsBean exist=new NullAwareBeanUtilsBean();
        exist.copyProperties(existingStudent,student);
        return ResponseEntity.ok(studentRepository.save(existingStudent));
    }

    @Override
    public ResponseEntity<Map<String,Boolean>> deleteStudent(Student student){
        Student existingStudent=studentRepository.findById(student.getId()).orElseThrow(()->new NotFoundByIdException("Student not exist with id:" +student.getId()));
        studentRepository.delete(existingStudent);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String,Boolean>> deleteStudentById(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Student not exist with id"+id));
        studentRepository.delete(student);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
