package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.models.Module;
import com.scaler.bookmyshow.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ModuleController {

    private ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public Module createModule(String name, String description){

        var createdModule = moduleService.createModule(name,description);

        return createdModule;


    }

}
