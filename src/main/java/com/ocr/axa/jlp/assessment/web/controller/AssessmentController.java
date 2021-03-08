package com.ocr.axa.jlp.assessment.web.controller;


import com.ocr.axa.jlp.assessment.model.Assessment;
import com.ocr.axa.jlp.assessment.service.AssessmentService;
import com.ocr.axa.jlp.assessment.web.exception.ControllerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/assessment")
public class AssessmentController {
    private static final Logger logger = LogManager.getLogger("generalController");

    @Autowired
    AssessmentService assessmentService;

    @GetMapping("/id")
    public ResponseEntity<Assessment> getAssessmentById(@RequestParam(required = true) Long patientId, @RequestParam(required = true) int assessmentId) {

        Assessment assessment = assessmentService.getAssessmentByPatient(patientId,assessmentId);

        if (assessment == null) {
            logger.error("calcul assessment : KO");
            throw new ControllerException("calcul assessment KO");
        } else {
            logger.info("calcul assessment  OK, patientId =" + patientId.toString());
            return new ResponseEntity(assessment, HttpStatus.OK);
        }

    }

    @GetMapping("/family")
    public ResponseEntity<List<Assessment>> getAssessmentById(@RequestParam(required = true) String familyName, @RequestParam(required = true) int assessmentId) {
        List<Assessment> assessments = assessmentService.getAssessmentByFamilyName(familyName,assessmentId);

        if (assessments.isEmpty()) {
            logger.error("calcul assessment for a family: KO");
            throw new ControllerException("calcul assessment KO, list empty");
        } else {
            logger.info("calcul assessment for a family: OK, patientFamilyName=" + familyName);
            return new ResponseEntity(assessments, HttpStatus.OK);
        }

    }
}
