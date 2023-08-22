package com.tecnico.matheus.controller;

import com.tecnico.matheus.dto.DepartmentSummaryDTO;
import com.tecnico.matheus.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartmentController {

    private final PersonRepository personRepository;

    public DepartmentController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<DepartmentSummaryDTO> getDepartmentSummaries() {
        return personRepository.getDepartmentSummaries();
    }
}

