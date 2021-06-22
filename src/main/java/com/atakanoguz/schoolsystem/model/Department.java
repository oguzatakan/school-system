package com.atakanoguz.schoolsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "max_lesson")
    private double maxLesson;

    @Column(name = "min_lesson")
    private double minLesson;

    @Column(name="description")
    private String lessonDescription;

    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<Student> students;

    public Department(Long id, String departmentName, double maxLesson, double minLesson, String lessonDescription, String phone) {
        this.id = id;
        this.departmentName = departmentName;
        this.maxLesson = maxLesson;
        this.minLesson = minLesson;
        this.lessonDescription = lessonDescription;
        this.phone = phone;
    }
}
