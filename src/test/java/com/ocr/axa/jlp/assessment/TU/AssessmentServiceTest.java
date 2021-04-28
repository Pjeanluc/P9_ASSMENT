package com.ocr.axa.jlp.assessment.TU;

import com.ocr.axa.jlp.assessment.model.Dto.Note;
import com.ocr.axa.jlp.assessment.model.Dto.Patient;
import com.ocr.axa.jlp.assessment.service.AssessmentServiceImpl;
import com.ocr.axa.jlp.assessment.service.NoteService;
import com.ocr.axa.jlp.assessment.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class AssessmentServiceTest {

    @Autowired
    AssessmentServiceImpl assessmentService;

    @MockBean
    NoteService noteService;

    @MockBean
    PatientService patientService;

    @Test
    void getLevelOfAssessmentTest() {
        // GIVEN
        // WHEN
        // THEN
        assertThat(assessmentService.getLevelOfAssessment(35,"F", 1)).isEqualTo("None");
        assertThat(assessmentService.getLevelOfAssessment(35,"F", 5)).isEqualTo("Borderline");
        assertThat(assessmentService.getLevelOfAssessment(30,"F", 2)).isEqualTo("Borderline");
        assertThat(assessmentService.getLevelOfAssessment(30,"F", 3)).isEqualTo("Borderline");
        assertThat(assessmentService.getLevelOfAssessment(30,"M", 4)).isEqualTo("In Danger");
        assertThat(assessmentService.getLevelOfAssessment(30,"F", 6)).isEqualTo("In Danger");
        assertThat(assessmentService.getLevelOfAssessment(35,"M", 7)).isEqualTo("In Danger");
        assertThat(assessmentService.getLevelOfAssessment(35,"F", 12)).isEqualTo("Early onset");
    }

    @Test
    void getAgeTest(){
        // GIVEN
        // WHEN
        LocalDate aujourdhui = LocalDate.now();
        LocalDate birthDate = aujourdhui.minusYears(22L);
        // THEN
        assertThat(assessmentService.getAge(birthDate)).isEqualTo(22);
    }

    @Test
    void searchAssessmentTest(){
        // GIVEN
        Note note = new Note();
        note.setNote("Taille");
        // WHEN
        // THEN
        assertThat(assessmentService.searchAssessment(note,1)).isEqualTo(1);

        }

    @Test
    void getAssessmentByPatientTest(){
        // GIVEN
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setFirstname("firstnametest");
        patient.setLastname("lastnametest");
        patient.setAddress("adressetest");
        patient.setPhoneNumber("0102030405");
        LocalDate aujourdhui = LocalDate.now();
        LocalDate birthDate = aujourdhui.minusYears(22L);
        patient.setBirthDate(birthDate);
        patient.setGenre("M");

        Note note = new Note();
        note.setNote("Taille");

        List<Note> notes = new ArrayList<>();
        notes.add(note);

        // WHEN
        Mockito.when(patientService.getPatientById(anyLong())).thenReturn(patient);
        Mockito.when(noteService.getListNotesPatient(anyLong())).thenReturn(notes);

        // THEN
        assertThat(assessmentService.getAssessmentByPatient(1L,1).getAssessmentLevel()).isEqualTo("None");


    }

    @Test
    void getAssessmentByfamilyName(){
        // GIVEN
        Patient patient = new Patient();
        patient.setId(1L);
        LocalDate aujourdhui = LocalDate.now();
        LocalDate birthDate = aujourdhui.minusYears(22L);
        patient.setBirthDate(birthDate);
        patient.setGenre("M");

        Note note = new Note();
        note.setNote("Taille");

        List<Note> notes = new ArrayList<>();
        notes.add(note);

        List<Patient> patients = new ArrayList<>();
        patients.add(patient);

        // WHEN
        Mockito.when(patientService.getPatientById(anyLong())).thenReturn(patient);
        Mockito.when(noteService.getListNotesPatient(anyLong())).thenReturn(notes);
        Mockito.when(patientService.getPatientByLastname(anyString())).thenReturn(patients);

        // THEN
        assertThat(assessmentService.getAssessmentByFamilyName("Test",1).get(0).getAssessmentLevel())
                .isEqualTo("None");


    }
}
