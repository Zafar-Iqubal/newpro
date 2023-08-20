package com.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	
}