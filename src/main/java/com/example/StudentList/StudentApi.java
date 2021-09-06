package com.example.StudentList;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentApi {

    private List<Student> studentList;

    public StudentApi() {
        this.studentList = new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Student getStudents(@PathVariable int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id).findFirst().get();
    }

    @GetMapping("/getAllStudents")
    public List<Student> getStudents() {
        return studentList;
    }

    @PostMapping("/addStudent")
    public boolean addStudent(@RequestBody Student student) {
        return studentList.add(student);
    }

    @PostMapping("/removeStudent/{id}")
    public boolean deleteStudent(@PathVariable int id) {
        Student studentToDelete = studentList.stream()
                .filter(student -> student.getId() == id).findFirst().get();
        return studentList.remove(studentToDelete);
    }
}
