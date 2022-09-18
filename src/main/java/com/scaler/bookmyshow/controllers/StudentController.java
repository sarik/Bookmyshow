package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.StudentCreationRequestDTO;
import com.scaler.bookmyshow.dtos.StudentCreationResponseDTO;
import com.scaler.bookmyshow.models.Module;
import com.scaler.bookmyshow.models.Student;
import com.scaler.bookmyshow.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentCreationResponseDTO createStudent(StudentCreationRequestDTO studentProfile){
        Student createdStudent = studentService.createStudent(studentProfile.getName());

        StudentCreationResponseDTO studentResponse = new StudentCreationResponseDTO();

        //Student newStudent = new Student(studentProfile.getName(),null);
        studentResponse.setStudent(createdStudent);

        return studentResponse;
    }

    public void addModule(Long studentId, Long moduleId){
        studentService.addModule(studentId,moduleId);
    }
}
