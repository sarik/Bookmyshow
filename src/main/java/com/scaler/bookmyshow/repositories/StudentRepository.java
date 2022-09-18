package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student save(Student student);

    @Override
    Optional<Student> findById(Long id);

}
