package com.example.blood.bank.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blood.bank.dto.DonorDTO;
import com.example.blood.bank.entities.Donor;
import com.example.blood.bank.repositories.DonorRepository;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Map<String, Double> averageIMCByAgeRange(List<DonorDTO> donors) {
        return donors.stream()
                .collect(Collectors.groupingBy(donor -> {
                    int age = calculateAge(donor.getBirthDate());
                    int lowerBound = (age / 10) * 10;
                    int upperBound = lowerBound + 9;
                    return lowerBound + "-" + upperBound;
                }, Collectors.averagingDouble(donor -> donor.getWeight() / (donor.getHeight() * donor.getHeight()))));
    }

    private int calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            return 0;
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public Map<String, Long> countCandidatesByState(List<DonorDTO> donors) {
        return donors.stream()
                .collect(Collectors.groupingBy(DonorDTO::getState, Collectors.counting()));
    }
    
    public Map<String, Double> calculateObesityPercentage(List<DonorDTO> donors) {
        long totalMen = donors.stream().filter(donor -> "M".equalsIgnoreCase(donor.getGender())).count();
        long totalWomen = donors.stream().filter(donor -> "F".equalsIgnoreCase(donor.getGender())).count();

        long obeseMen = donors.stream()
                .filter(donor -> "M".equalsIgnoreCase(donor.getGender()) && calculateIMC(donor) > 30)
                .count();

        long obeseWomen = donors.stream()
                .filter(donor -> "F".equalsIgnoreCase(donor.getGender()) && calculateIMC(donor) > 30)
                .count();

        double percentageObeseMen = (double) obeseMen / totalMen * 100;
        double percentageObeseWomen = (double) obeseWomen / totalWomen * 100;

        return Map.of("Homens", percentageObeseMen, "Mulheres", percentageObeseWomen);
    }
    
    private double calculateIMC(DonorDTO donor) {
        return donor.getWeight() / (donor.getHeight() * donor.getHeight());
    }
    
    public Map<String, Double> averageAgeByBloodType(List<DonorDTO> donors) {
        return donors.stream()
                .collect(Collectors.groupingBy(DonorDTO::getBloodType,
                        Collectors.averagingInt(donor -> calculateAge(donor.getBirthDate()))));
    }
    
    public Map<String, Long> possibleDonorsByBloodType(List<DonorDTO> donors) {
        Map<String, List<DonorDTO>> donorsByBloodType = donors.stream()
                .collect(Collectors.groupingBy(DonorDTO::getBloodType));

        return Map.of(
                "A+", countPossibleDonors(donorsByBloodType, "A+", "A-", "O+", "O-"),
                "A-", countPossibleDonors(donorsByBloodType, "A-", "O-"),
                "B+", countPossibleDonors(donorsByBloodType, "B+", "B-", "O+", "O-"),
                "B-", countPossibleDonors(donorsByBloodType, "B-", "O-"),
                "AB+", countPossibleDonors(donorsByBloodType, "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"),
                "AB-", countPossibleDonors(donorsByBloodType, "A-", "B-", "AB-", "O-"),
                "O+", countPossibleDonors(donorsByBloodType, "O+", "O-"),
                "O-", countPossibleDonors(donorsByBloodType, "O-")
        );
    }

    private long countPossibleDonors(Map<String, List<DonorDTO>> donorsByBloodType, String... compatibleTypes) {
        return donorsByBloodType.entrySet().stream()
                .filter(entry -> List.of(compatibleTypes).contains(entry.getKey()))
                .mapToLong(entry -> entry.getValue().size())
                .sum();
    }
    
    public List<DonorDTO> filterValidDonors(List<DonorDTO> donors) {
        return donors.stream()
                .filter(donor -> {
                    int age = calculateAge(donor.getBirthDate());
                    return age >= 16 && age <= 69 && donor.getWeight() > 50;
                })
                .collect(Collectors.toList());
    }
}

