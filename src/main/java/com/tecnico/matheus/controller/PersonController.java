package com.tecnico.matheus.controller;

import com.tecnico.matheus.dto.PersonGastosDTO;
import com.tecnico.matheus.entity.Person;
import com.tecnico.matheus.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/pessoas")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = personService.getAllPeople();
        return ResponseEntity.ok(people);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personService.getPersonById(id);

        if (person.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(person.get());
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person addedPerson = personService.addPerson(person);
        return ResponseEntity.ok(addedPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        Person updated = personService.updatePerson(id, updatedPerson);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @GetMapping("/gastos")
    public ResponseEntity<List<PersonGastosDTO>> getPeopleGastosByNameAndPeriod(
            @RequestParam String nome,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        List<PersonGastosDTO> peopleGastos = personService.getPeopleGastosByNameAndPeriod(nome, dataInicio, dataFim);
        return ResponseEntity.ok(peopleGastos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}