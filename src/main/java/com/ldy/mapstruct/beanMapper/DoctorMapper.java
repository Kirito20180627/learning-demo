package com.ldy.mapstruct.beanMapper;

import com.ldy.mapstruct.bean.Doctor;
import com.ldy.mapstruct.bean.DoctorDTO;
import com.ldy.mapstruct.bean.Education;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PatientMapper.class}, componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(source = "doctor.specialty", target = "specialization")
    @Mapping(source = "education.degreeName", target = "degree")
    @Mapping(source = "doctor.patientList", target = "patientDTOList")
    DoctorDTO toDTO(Doctor doctor, Education education);

}
