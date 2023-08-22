package com.tecnico.matheus.dto;

public class DepartmentSummaryDTO {
    private String department;
    private int numberOfPeople;
    private int numberOfTasks;

    public DepartmentSummaryDTO(String department, int numberOfPeople, int numberOfTasks) {
        this.department = department;
        this.numberOfPeople = numberOfPeople;
        this.numberOfTasks = numberOfTasks;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }
}
