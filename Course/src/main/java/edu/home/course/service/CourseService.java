package edu.home.course.service;

import edu.home.course.dto.CourseDTO;
import edu.home.course.model.Course;
import edu.home.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(new Course());
        return new CourseDTO(course.getTitle(), course.getUnit());
    }
}
