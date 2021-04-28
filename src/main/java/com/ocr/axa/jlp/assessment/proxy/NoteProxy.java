package com.ocr.axa.jlp.assessment.proxy;

import com.ocr.axa.jlp.assessment.model.Dto.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "assessment-note", url = "http://note:8082",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface NoteProxy {

    @GetMapping(value = "/patHistory/")
    List<Note> getListNotesPatient(@RequestParam("patientId") Long id);
}
