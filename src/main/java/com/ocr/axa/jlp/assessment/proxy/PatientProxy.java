package com.ocr.axa.jlp.assessment.proxy;

import com.ocr.axa.jlp.assessment.model.Dto.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "assessement-patient", url = "http://patient:8084",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface PatientProxy {

    @GetMapping(value = "/patient/id")
    Patient getPatientById(@RequestParam("id") Long id);

    @GetMapping(value = "/patient/family")
    List<Patient> getPatientByFamilyName(@RequestParam("familyName") String familyName);
}
