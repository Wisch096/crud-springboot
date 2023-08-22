package com.tecnico.matheus.controller;

import com.tecnico.matheus.entity.Person;
import com.tecnico.matheus.entity.Task;
import com.tecnico.matheus.repository.TaskRepository;
import com.tecnico.matheus.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task addedTask = taskService.addTask(task);
        return ResponseEntity.ok(addedTask);
    }

    @PutMapping("/alocar/{id}")
    public ResponseEntity<Task> allocateTask(
            @PathVariable Long id,
            @RequestBody Person person
    ) {
        Task allocatedTask = taskService.allocateTask(id, person);

        if (allocatedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allocatedTask);
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Task> finishTask(@PathVariable Long id) {
        Task finishedTask = taskService.finishTask(id);

        if (finishedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(finishedTask);
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Task>> getOldestUnallocatedTasks(@RequestParam(defaultValue = "3") int limit) {
        List<Task> tasks = taskService.getOldestUnallocatedTasks(limit);
        return ResponseEntity.ok(tasks);
    }
}
