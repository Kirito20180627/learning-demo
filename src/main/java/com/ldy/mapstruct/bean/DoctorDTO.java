package com.ldy.mapstruct.bean;

import lombok.Data;

import java.util.List;

@Data
public class DoctorDTO {
    private int id;
    private String name;
    private String specialization;
    private String degree;
    private List<PatientDTO> patientDTOList;
}
