package com.ocr.axa.jlp.assessment.model;

public class Assessment {
    private Long assessmentPatientId;
    private int assessmentId;
    private String assessmentLevel;

    public Assessment() {
    }

    public Assessment(Long patientId, int assessmentId, String assessmentLevel) {
        this.assessmentPatientId =patientId;
        this.assessmentId = assessmentId;
        this.assessmentLevel = assessmentLevel;
    }

    public Long getAssessmentPatientId() {
        return assessmentPatientId;
    }

    public void setAssessmentPatientId(Long assessmentPatientId) {
        this.assessmentPatientId = assessmentPatientId;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getAssessmentLevel() {
        return assessmentLevel;
    }

    public void setAssessmentLevel(String assessmentLevel) {
        this.assessmentLevel = assessmentLevel;
    }
}
