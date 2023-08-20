package com.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.entities.Lender;

public interface LenderRepository extends JpaRepository<Lender, Long> {
}
