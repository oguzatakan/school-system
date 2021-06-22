package com.atakanoguz.schoolsystem.repository;

import com.atakanoguz.schoolsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByDepartmentId(Long id);
}
