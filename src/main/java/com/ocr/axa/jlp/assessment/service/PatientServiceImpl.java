package com.ocr.axa.jlp.assessment.service;

import com.ocr.axa.jlp.assessment.model.Dto.Patient;
import com.ocr.axa.jlp.assessment.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientProxy patientProxy;

    @Override
    public Patient getPatientById(Long id) {
        return patientProxy.getPatientById(id);
    }

    @Override
    public List<Patient> getPatientByLastname(String familyName) {return patientProxy.getPatientByFamilyName(familyName);

    }
}
