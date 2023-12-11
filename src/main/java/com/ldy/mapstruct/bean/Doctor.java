package com.ldy.mapstruct.bean;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Doctor {
    private int id;
    private String name;
    private String specialty;
    private List<Patient> patientList;
}
