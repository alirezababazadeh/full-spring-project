package edu.home.student.controller;

import edu.home.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("student-base-inf/{id}")
    public Object getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }
}
