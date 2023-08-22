package com.tecnico.matheus.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    @OneToMany(mappedBy = "allocatedPerson", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> allocatedTasks = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Task> getAllocatedTasks() {
        return allocatedTasks;
    }

    public void setAllocatedTasks(List<Task> allocatedTasks) {
        this.allocatedTasks = allocatedTasks;
    }

}
