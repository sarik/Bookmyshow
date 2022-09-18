package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Module;
import com.scaler.bookmyshow.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuleRespository extends JpaRepository<Module,Long> {

    Module save(Module module);

    @Override
    Optional<Module> findById(Long id);

}
