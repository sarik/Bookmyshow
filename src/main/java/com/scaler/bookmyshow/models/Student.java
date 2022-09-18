package com.scaler.bookmyshow.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Student extends BaseModel {

    private String name;

    @ManyToOne
    private Module module;

    public Student() {

    }

    public Student(String name, Module module) {
        this.name = name;
        this.module = module;
    }


}
