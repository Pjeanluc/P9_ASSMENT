package com.ocr.axa.jlp.assessment.model.Dto;

import java.time.LocalDate;

public class Note {
    private String id;
    private String textNote;
    private Long patientId;
    private LocalDate dateNote;

    public Note() {
    }

    public Note(String id, String textNote, Long patientId, LocalDate dateNote) {
        this.id = id;
        this.patientId = patientId;
        this.textNote = textNote;
        this.dateNote = dateNote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
