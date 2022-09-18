package com.scaler.bookmyshow.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Module extends BaseModel{

    private String name;
    private String description;

    @OneToMany(mappedBy = "module")
    private List<Student> students;


    public Module(String name, String description, List<Student> students) {
        this.name = name;
        this.description = description;
        this.students = students;
    }
}
