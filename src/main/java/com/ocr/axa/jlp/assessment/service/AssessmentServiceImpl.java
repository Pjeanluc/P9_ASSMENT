package com.ocr.axa.jlp.assessment.service;

import com.ocr.axa.jlp.assessment.model.Assessment;
import com.ocr.axa.jlp.assessment.model.Dto.Note;
import com.ocr.axa.jlp.assessment.model.Dto.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService{

    @Autowired
    PatientService patientService;

    @Autowired
    NoteService noteService;

    private List<String> wordsDiabetConst = Arrays.asList("Hémoglobine A1C","Microalbumine","Taille","Poids","Fumeur","Anormal", "Cholestérol","Vertige","Rechute","Réaction","Anticorps");

    @Override
    public Assessment getAssessmentByPatient(Long id, int assessmentId) {

        Assessment assessment = new Assessment();
        assessment.setAssessmentId(assessmentId);
        assessment.setAssessmentPatientId(id);

        Patient patient = patientService.getPatientById(id);
        int age = getAge(patient.getBirthDate());
        String sex = patient.getGenre();

        int frequence =0;


        if (patient != null){
            List<Note> notes = noteService.getListNotesPatient(patient.getId());
            for (Note n : notes)
            {
                frequence = frequence + searchAssessment(n,assessmentId);
            };
        }

        assessment.setAssessmentLevel(getLevelOfAssessment(age,sex,frequence));

        return assessment;
    }

    @Override
    public List<Assessment> getAssessmentByFamilyName(String familyName, int assessmentId) {
        List<Assessment> assessments = new ArrayList<>();
        List<Patient> patients = patientService.getPatientByLastname(familyName);

        for (Patient p : patients){
            Assessment assessment = getAssessmentByPatient(p.getId(), assessmentId);
            assessments.add(assessment);
        }

        return assessments;
    }

    public int getAge(LocalDate birthdate) {
        LocalDate now = LocalDate.now(ZoneId.of("Europe/Paris"));
        return Period.between(birthdate, now).getYears();
    }

    public int searchAssessment(Note note, int assessmentId) {
        int numberOfAssement = 0;

        for (String w : wordsDiabetConst)
        {
            if (note.getNote().toLowerCase().indexOf(w.toLowerCase()) != -1){
                numberOfAssement += 1;
            }
        }

        return numberOfAssement;
    }

    public  String getLevelOfAssessment(int age, String sex, int numberOfDeclencher) {
        String levelCalculate = "NONE";

        if (numberOfDeclencher < 2) {
            levelCalculate = "None";
        } else if (numberOfDeclencher < 6 && age > 30) {
            levelCalculate = "Borderline";
        } else if (numberOfDeclencher < 3 && age <= 30) {
            levelCalculate = "Borderline";
        } else if (numberOfDeclencher < 4 && age <= 30) {
            levelCalculate = "Borderline";
        } else if (numberOfDeclencher < 5 && age <= 30 && sex.contains("M")) {
            levelCalculate = "In Danger";
        } else if (numberOfDeclencher < 7 && age <= 30 && sex.contains("F")) {
            levelCalculate = "In Danger";
        } else if (numberOfDeclencher < 8 && age > 30) {
            levelCalculate = "In Danger";
        } else {
            levelCalculate = "Early onset";
        }

        return levelCalculate;
    }

}
