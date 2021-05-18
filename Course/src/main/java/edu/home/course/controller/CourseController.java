package edu.home.course.controller;

import edu.home.course.dto.CourseDTO;
import edu.home.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("course-base-inf/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }
}
