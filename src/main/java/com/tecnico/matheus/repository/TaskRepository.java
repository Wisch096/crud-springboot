package com.tecnico.matheus.repository;

import com.tecnico.matheus.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAllocatedPersonIsNullOrderByDeadline();

    @Query(value = "SELECT t FROM Task t WHERE t.allocatedPerson IS NULL ORDER BY t.deadline ASC")
    List<Task> findOldestUnallocatedTasks(int limit);

}
