package com.ocr.axa.jlp.assessment.TU;

import com.ocr.axa.jlp.assessment.model.Assessment;
import com.ocr.axa.jlp.assessment.service.AssessmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WithMockUser(roles = "USER")
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class AssessmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssessmentService assessmentService;

    String patientNameConst = "usernametest";

    @Test
    void getAssessmentByIdTest() throws Exception {

        // GIVEN
        Assessment assessment = new Assessment();
        assessment.setAssessmentPatientId(0L);
        assessment.setAssessmentLevel("LevelTest");
        Mockito.when(assessmentService.getAssessmentByPatient(anyLong(),anyInt())).thenReturn(assessment);

        // WHEN
        // THEN

        this.mockMvc
                .perform(get("/assessment/id?patientId=0&assessmentId=0")
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }
    @Test
    void getAssessmentByFamilyTest() throws Exception {

        // GIVEN
        List<Assessment> assessments = new ArrayList<>();
        Assessment assessment = new Assessment();
        assessment.setAssessmentPatientId(0L);
        assessment.setAssessmentLevel("LevelTest");
        assessments.add(assessment);

        Mockito.when(assessmentService.getAssessmentByFamilyName(anyString(),anyInt())).thenReturn(assessments);

        // WHEN
        // THEN

        this.mockMvc
                .perform(get("/assessment/family?familyName=name&assessmentId=0")
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }
}
