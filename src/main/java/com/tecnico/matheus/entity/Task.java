package com.tecnico.matheus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(exclude = "allocatedPerson")
@ToString(exclude = "allocatedPerson")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate deadline;
    private String department;
    private Integer duration;
    private Boolean finished;

    @ManyToOne
    @JoinColumn(name = "allocated_person_id")
    @JsonBackReference
    private Person allocatedPerson;
}






