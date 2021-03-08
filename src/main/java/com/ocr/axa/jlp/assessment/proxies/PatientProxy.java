package com.ocr.axa.jlp.assessment.proxies;

import com.ocr.axa.jlp.assessment.model.Dto.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "assessement-patient", url = "http://localhost:8084",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface PatientProxy {

    @GetMapping(value = "/patient")
    Patient getPatientById(@RequestBody Long id);

    @GetMapping(value = "/patient/family")
    List<Patient> getPatientByFamilyName();
}
