package com.crystal.springmongodbproject.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/* https://youtu.be/8S8o46avgAw */

@Document
public class Subject {
    @Field(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
