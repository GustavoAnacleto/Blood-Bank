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
    
    @GetMapping("/count-by-state")
    public ResponseEntity<Map<String, Long>> countCandidatesByState(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Long> result = donorService.countCandidatesByState(validDonors);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Donor>> getAllDonors() {
        List<Donor> donors = donorService.getAllDonors();
        return ResponseEntity.ok(donors);
    }

    @PostMapping("/average-imc")
    public ResponseEntity<Map<String, Double>> getAverageIMCByAgeRange(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Double> averageIMC = donorService.averageIMCByAgeRange(validDonors);
        return ResponseEntity.ok(averageIMC);
    }

    @PostMapping("/obesity-percentage")
    public ResponseEntity<Map<String, Double>> getObesityPercentage(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Double> obesityPercentage = donorService.calculateObesityPercentage(validDonors);
        return ResponseEntity.ok(obesityPercentage);
    }

    @PostMapping("/average-age-by-blood-type")
    public ResponseEntity<Map<String, Double>> getAverageAgeByBloodType(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Double> averageAgeByBloodType = donorService.averageAgeByBloodType(validDonors);
        return ResponseEntity.ok(averageAgeByBloodType);
    }

    @PostMapping("/possible-donors-by-blood-type")
    public ResponseEntity<Map<String, Long>> getPossibleDonorsByBloodType(@RequestBody List<DonorDTO> donors) {
        List<DonorDTO> validDonors = donorService.filterValidDonors(donors);
        Map<String, Long> possibleDonorsByBloodType = donorService.possibleDonorsByBloodType(validDonors);
        return ResponseEntity.ok(possibleDonorsByBloodType);
    }
}
