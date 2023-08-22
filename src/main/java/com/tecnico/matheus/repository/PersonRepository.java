package com.tecnico.matheus.repository;


import com.tecnico.matheus.dto.DepartmentSummaryDTO;
import com.tecnico.matheus.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT DISTINCT p FROM Person p JOIN FETCH p.allocatedTasks t " +
            "WHERE p.name = :name AND t.deadline BETWEEN :startDate AND :endDate")
    List<Person> findByNameAndTaskPeriod(
            @Param("name") String name,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    @Query("SELECT p.department, COUNT(p) " +
            "FROM Person p GROUP BY p.department")
    List<Object[]> countPeopleByDepartment();

    @Query("SELECT p.department, COUNT(t) " +
            "FROM Person p LEFT JOIN p.allocatedTasks t GROUP BY p.department")
    List<Object[]> countTasksByDepartment();

    default List<DepartmentSummaryDTO> getDepartmentSummaries() {
        List<DepartmentSummaryDTO> summaries = new ArrayList<>();

        List<Object[]> peopleCounts = countPeopleByDepartment();
        List<Object[]> taskCounts = countTasksByDepartment();

        for (Object[] peopleCount : peopleCounts) {
            String department = (String) peopleCount[0];
            int numberOfPeople = ((Number) peopleCount[1]).intValue();

            Optional<Object[]> matchingTaskCount = taskCounts.stream()
                    .filter(taskCount -> department.equals(taskCount[0]))
                    .findFirst();

            if (matchingTaskCount.isPresent()) {
                int numberOfTasks = ((Number) matchingTaskCount.get()[1]).intValue();
                summaries.add(new DepartmentSummaryDTO(department, numberOfPeople, numberOfTasks));
            }
        }

        return summaries;
    }

}

