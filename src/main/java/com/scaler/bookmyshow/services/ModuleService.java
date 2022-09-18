package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.Module;
import com.scaler.bookmyshow.repositories.ModuleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {

    private ModuleRespository moduleRespository;

    @Autowired
    public ModuleService(ModuleRespository moduleRespository) {
        this.moduleRespository = moduleRespository;
    }

    public  Module createModule(String name,String description){
        var module = new Module(name,description,null);

        var savedModule = moduleRespository.save(module);

        return savedModule;

    }
}
