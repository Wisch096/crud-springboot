package com.tecnico.matheus.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "allocatedTasks")
@ToString(exclude = "allocatedTasks")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    @OneToMany(mappedBy = "allocatedPerson", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> allocatedTasks = new ArrayList<>();
}
