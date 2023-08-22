package com.tecnico.matheus.dto;

public class PersonGastosDTO {
    private Long id;
    private String name;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private Double mediaHorasGastas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMediaHorasGastas() {
        return mediaHorasGastas;
    }

    public void setMediaHorasGastas(Double mediaHorasGastas) {
        this.mediaHorasGastas = mediaHorasGastas;
    }
}

