package com.example.blood.bank.dto;

import java.time.LocalDate;

import com.example.blood.bank.entities.Donor;

public class DonorDTO {

	private Long id;
    private String name;
    private LocalDate birthDate;
    private double weight;
    private double height;
    private String gender;
    private String bloodType;
    private String state;
    
	public DonorDTO(Long id, String name, LocalDate birthDate, double weight, double height, String gender, String bloodType,
			String state) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.bloodType = bloodType;
		this.state = state;
	}

	public DonorDTO(Donor entity) {
		id = entity.getId();
		name = entity.getName();
		birthDate = entity.getBirthDate();
		weight = entity.getWeight();
		height = entity.getHeight();
		gender = entity.getGender();
		bloodType = entity.getBloodType();
		state = entity.getState();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

	public String getGender() {
		return gender;
	}

	public String getBloodType() {
		return bloodType;
	}

	public String getState() {
		return state;
	}
	
	
    
	
    
	
    
    
}
