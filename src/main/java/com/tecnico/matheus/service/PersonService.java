package com.tecnico.matheus.service;

import com.tecnico.matheus.dto.PersonGastosDTO;
import com.tecnico.matheus.entity.Person;
import com.tecnico.matheus.entity.Task;
import com.tecnico.matheus.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        Optional<Person> existingPerson = personRepository.findById(id);

        if (existingPerson.isEmpty()) {
            return null; // Pode lançar uma exceção personalizada se preferir
        }

        Person personToUpdate = existingPerson.get();
        personToUpdate.setName(updatedPerson.getName());
        personToUpdate.setDepartment(updatedPerson.getDepartment());

        return personRepository.save(personToUpdate);
    }

    public List<PersonGastosDTO> getPeopleGastosByNameAndPeriod(String name, LocalDate startDate, LocalDate endDate) {
        List<Person> people = personRepository.findByNameAndTaskPeriod(name, startDate, endDate);
        return people.stream()
                .map(this::convertToPersonGastosDTO)
                .collect(Collectors.toList());
    }

    private PersonGastosDTO convertToPersonGastosDTO(Person person) {
        Double mediaHorasGastas = calculateAverageTaskDuration(person.getAllocatedTasks());

        PersonGastosDTO personGastosDTO = new PersonGastosDTO();
        personGastosDTO.setId(person.getId());
        personGastosDTO.setName(person.getName());
        personGastosDTO.setDepartment(person.getDepartment());
        personGastosDTO.setMediaHorasGastas(mediaHorasGastas);

        return personGastosDTO;
    }

    private Double calculateAverageTaskDuration(List<Task> tasks) {
        if (tasks.isEmpty()) {
            return 0.0;
        }
        return tasks.stream()
                .mapToInt(Task::getDuration)
                .average()
                .orElse(0.0);
    }



    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
