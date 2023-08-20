package com.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.entities.CreditIntermediary;

public interface CreditIntermediaryRepository extends JpaRepository<CreditIntermediary, Long> {
}
