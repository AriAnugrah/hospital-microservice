package com.ari.patient.controller;



import com.ari.patient.model.entity.Patient;
import com.ari.patient.service.PatientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("patient")
@EnableDiscoveryClient
public class PatientController {

    private RestTemplate restTemplate;

    private PatientService patientService;

    public PatientController(RestTemplate restTemplate, PatientService patientService) {
        this.restTemplate = restTemplate;
        this.patientService = patientService;
    }

    @GetMapping("/halo")
    @HystrixCommand(fallbackMethod = "fallBack")
    public String halo(){
        return restTemplate.getForObject("http://room-service/room/halo",String.class) + " panggil dari patient";
    }

    @GetMapping("/get-room")
    @HystrixCommand(fallbackMethod = "fallBack")
    public List<Object> getAllDepartment() {
        return (List<Object>) restTemplate.getForObject("http://room-service/room", Object.class);
    }

    @GetMapping
    public List<Patient> findAllEmployee() {
        return patientService.findAllEmployee();
    }

    public String fallBack(Throwable hystrixCommand){
        return "Fallback Error Request";
    }
}