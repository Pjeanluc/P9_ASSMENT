package com.ocr.axa.jlp.assessment.service;

import com.ocr.axa.jlp.assessment.model.Dto.Note;
import com.ocr.axa.jlp.assessment.proxy.NoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteProxy noteProxy;

    @Override
    public List<Note> getListNotesPatient(long id) {
        return noteProxy.getListNotesPatient(id);
    }
}
