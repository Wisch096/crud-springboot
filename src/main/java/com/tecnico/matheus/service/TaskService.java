package com.tecnico.matheus.service;

import com.tecnico.matheus.dto.DepartmentSummaryDTO;
import com.tecnico.matheus.entity.Person;
import com.tecnico.matheus.entity.Task;
import com.tecnico.matheus.repository.PersonRepository;
import com.tecnico.matheus.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getPendingTasks() {
        return taskRepository.findByAllocatedPersonIsNullOrderByDeadline();
    }

    public Task allocateTask(Long taskId, Person person) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (taskOptional.isEmpty()) {
            return null;
        }

        Task task = taskOptional.get();

        if (!task.getDepartment().equals(person.getDepartment())) {
            return null;
        }

        task.setAllocatedPerson(person);
        return taskRepository.save(task);
    }

    public Task finishTask(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (taskOptional.isEmpty()) {
            return null;
        }

        Task task = taskOptional.get();
        task.setFinished(true);
        return taskRepository.save(task);
    }

    public List<Task> getOldestUnallocatedTasks(int limit) {
        return taskRepository.findOldestUnallocatedTasks(limit);
    }

    public List<DepartmentSummaryDTO> getDepartmentSummaries() {
        return personRepository.getDepartmentSummaries();
    }
}

