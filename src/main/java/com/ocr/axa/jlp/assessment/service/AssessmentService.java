package com.ocr.axa.jlp.assessment.service;

import com.ocr.axa.jlp.assessment.model.Assessment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssessmentService {

    public Assessment getAssessmentByPatient (Long id, int assessmentId);
    public List<Assessment> getAssessmentByFamilyName (String familyName,int assessmentId);

}
