package com.ocr.axa.jlp.assessment.service;

import com.ocr.axa.jlp.assessment.model.Assessment;
import com.ocr.axa.jlp.assessment.model.Dto.Note;
import com.ocr.axa.jlp.assessment.model.Dto.Patient;
import com.ocr.axa.jlp.assessment.proxies.NoteProxy;
import com.ocr.axa.jlp.assessment.proxies.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    PatientProxy patientProxy;

    @Autowired
    NoteProxy noteProxy;

    @Override
    public Assessment getAssessmentByPatient(Long id, int assessmentId) {

        Assessment assessment = new Assessment();
        assessment.setAssessmentId(assessmentId);
        assessment.setAssessmentPatientId(id);

        Patient patient = patientProxy.getPatientById(id);
        int age = getAge(patient.getBirthdate());
        String sex = patient.getSex();

        int frequence =0;

        if (patient != null){
            List<Note> notes = noteProxy.getListNotesPatient(patient.getId());
            for (Note note : notes)
            {
                frequence = frequence + searchAssessment(note,assessmentId);
            };
        }

        assessment.setAssessmentLevel(getLevelOfAssessment(age,sex,frequence));

        return assessment;
    }

    @Override
    public List<Assessment> getAssessmentByFamilyName(String familyName, int assessmentId) {

        return null;
    }

    private int getAge(LocalDate birthdate) {
        LocalDate now = LocalDate.now(ZoneId.of("Europe/Paris"))
        return Period.between(birthdate, now).getYears();
    }

    private int searchAssessment(Note note, int assessmentId) {
        int numberOfAssement = 0;

        return numberOfAssement;
    }

    private  String getLevelOfAssessment(int age, String sex, int numberOfDeclencher) {
        String levelCalculate = "NONE";
        return levelCalculate;
    }

}
