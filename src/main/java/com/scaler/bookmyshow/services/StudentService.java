package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.Module;
import com.scaler.bookmyshow.models.Student;
import com.scaler.bookmyshow.repositories.ModuleRespository;
import com.scaler.bookmyshow.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentRepository studentRepository;
    public ModuleRespository moduleRespository;

    @Autowired
    public StudentService(StudentRepository studentRepository, ModuleRespository moduleRespository) {
        this.studentRepository = studentRepository;
        this.moduleRespository =moduleRespository;
    }

    public Student createStudent(String name){
        Student newStudent =  new Student(name,null);

        Student savedStudent = studentRepository.save(newStudent);

        return savedStudent;
    }

    public void addModule(Long studentId, Long moduleId){
        var studentOption = studentRepository.findById(studentId);
        var moduleOption = moduleRespository.findById(moduleId);

        Student student = null;
        Module module = null;
        if(studentOption.isPresent()){
            student = studentOption.get();
        }
        if(moduleOption.isPresent()){
            module = moduleOption.get();
        }

        student.setModule(module);
        studentRepository.save(student);
    }
}
