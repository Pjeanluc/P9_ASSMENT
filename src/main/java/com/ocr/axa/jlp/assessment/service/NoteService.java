package com.ocr.axa.jlp.assessment.service;

import com.ocr.axa.jlp.assessment.model.Dto.Note;

import java.util.List;

public interface NoteService {
    List<Note> getListNotesPatient(long id);
}
