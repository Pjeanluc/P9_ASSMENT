package com.ocr.axa.jlp.assessment.service;

import java.util.List;
import com.ocr.axa.jlp.assessment.model.Assessment;

public interface AssessmentService {

    public Assessment getAssessmentByPatient (Long id, int assessmentId);
    public List<Assessment> getAssessmentByFamilyName (String familyName,int assessmentId);

}
