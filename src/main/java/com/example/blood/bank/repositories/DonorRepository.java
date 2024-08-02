package com.example.blood.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blood.bank.entities.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

}
