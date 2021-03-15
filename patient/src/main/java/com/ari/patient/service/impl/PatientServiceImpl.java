package com.ari.patient.service.impl;

import com.ari.patient.model.entity.Patient;
import com.ari.patient.repository.PatientRepository;
import com.ari.patient.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAllEmployee() {
        return patientRepository.findAll();
    }
}
