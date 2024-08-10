package com.example.blood.bank.controllers;

import java.util.List;  
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blood.bank.dto.DonorDTO;
import com.example.blood.bank.entities.Donor;
import com.example.blood.bank.service.DonorService;

@RestController
@RequestMapping(value = "/donors")
public class DonorController {

    @Autowired
    private DonorService donorService;
    
    @PostMapping("/count-by-state")
    public ResponseEntity<Map<String, Long>> candidatesByState(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Long> result = donorService.candidatesByState(validDonors);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Donor>> getAllDonors() {
        List<Donor> donors = donorService.getAllDonors();
        return ResponseEntity.ok(donors);
    }
    
    
    @PostMapping("/average-imc")
    public ResponseEntity<Map<String, Double>> AverageIMCByAgeRange(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Double> averageIMC = donorService.averageIMCByAgeRange(validDonors);
        return ResponseEntity.ok(averageIMC);
    }

    @PostMapping("/obesity-percentage")
    public ResponseEntity<Map<String, Double>> obesityPercentage(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Double> obesityPercentage = donorService.calculateObesityPercentage(validDonors);
        return ResponseEntity.ok(obesityPercentage);
    }

    @PostMapping("/average-age-by-blood-type")
    public ResponseEntity<Map<String, Double>> averageAgeByBloodType(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Double> averageAgeByBloodType = donorService.averageAgeByBloodType(validDonors);
        return ResponseEntity.ok(averageAgeByBloodType);
    }

    @PostMapping("/possible-donors-by-blood-type")
    public ResponseEntity<Map<String, Long>> possibleDonorsByBloodType(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Long> possibleDonorsByBloodType = donorService.possibleDonorsByBloodType(validDonors);
        return ResponseEntity.ok(possibleDonorsByBloodType);
    }
    @PostMapping("/donors")
    public ResponseEntity<List<Donor>> saveDonors(@RequestBody List<Donor> donors) {
        List<Donor> donorsSalvos = donorService.saveDonors(donors);
        return ResponseEntity.ok(donorsSalvos);
    }


}
