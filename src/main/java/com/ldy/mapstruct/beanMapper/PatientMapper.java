package com.ldy.mapstruct.beanMapper;

import com.ldy.mapstruct.bean.Patient;
import com.ldy.mapstruct.bean.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDTO toDTO(Patient patient);
}
