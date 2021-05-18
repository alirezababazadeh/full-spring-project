package edu.home.student.service;

import edu.home.student.dto.StudentDTO;
import edu.home.student.model.Student;
import edu.home.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(new Student());
        String fullName = student.getFirstName() + " " + student.getLastName();
        return new StudentDTO(fullName, student.getField());
    }
}
