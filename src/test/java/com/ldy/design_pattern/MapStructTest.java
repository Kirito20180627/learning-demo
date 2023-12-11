package com.ldy.design_pattern;

import com.google.common.collect.Lists;
import com.ldy.mapstruct.bean.Doctor;
import com.ldy.mapstruct.bean.Education;
import com.ldy.mapstruct.bean.Patient;
import com.ldy.mapstruct.beanMapper.DoctorMapper;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MapStructTest {

    @Test
    public void test() {

        Patient patient = Patient.builder()
                .id(1)
                .name("Wu")
                .build();

        List<Patient> list = Lists.newArrayList();
        list.add(patient);
        Doctor doctor = Doctor.builder()
                .id(1)
                .name("Li")
                .specialty("XXX")
                .patientList(list)
                .build();

        Education education = Education.builder()
                .degreeName("Ph.D")
                .build();

        System.out.println(DoctorMapper.INSTANCE.toDTO(doctor, education));

    }
}
