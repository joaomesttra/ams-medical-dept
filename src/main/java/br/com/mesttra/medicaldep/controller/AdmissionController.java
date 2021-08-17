package br.com.mesttra.medicaldep.controller;

import br.com.mesttra.medicaldep.entity.Admission;
import br.com.mesttra.medicaldep.service.AdmissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admissions")
public class AdmissionController {

    AdmissionService admissionService;

    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @PostMapping
    public Admission registerAdmission(@RequestBody Admission admission) {
        return admissionService.registerAdmission(admission);
    }
}
