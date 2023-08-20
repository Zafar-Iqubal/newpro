package com.loan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.dto.LoanDTO;
import com.loan.entities.Loan;
import com.loan.repository.LoanRepository;
import com.loan.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
   
	@Autowired
	private LoanRepository loanRepository; 
    // You'll need to define this repository

   
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan saveLoan(LoanDTO loanDTO) {
        // Convert LoanDTO to Loan entity and save it using the repository
        Loan loan = convertToLoanEntity(loanDTO);
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    @Override
    public Loan updateLoan(Long id, LoanDTO loanDTO) {
        Loan existingLoan = loanRepository.findById(id).orElse(null);
        if (existingLoan != null) {
            // Update existingLoan with data from loanDTO and save
            updateLoanEntity(existingLoan, loanDTO);
            return loanRepository.save(existingLoan);
        }
        return null; // Return null if loan with given id is not found
    }

    @Override
    public boolean deleteLoan(Long id) {
        Loan existingLoan = loanRepository.findById(id).orElse(null);
        if (existingLoan != null) {
            loanRepository.delete(existingLoan);
            return true;
        }
        return false; // Return false if loan with given id is not found
    }

    // You would need to define methods to convert between LoanDTO and Loan entity
    private Loan convertToLoanEntity(LoanDTO loanDTO) {
        // Implement the conversion logic
    	 Loan loan = new Loan();
         loan.setConsumerName(loanDTO.getConsumerName());
         loan.setCurrentDate(loanDTO.getCurrentDate());
         loan.setValidityDate(loanDTO.getValidityDate());
         loan.setReference(loanDTO.getReference());
         return loan;
    	
    }

    private void updateLoanEntity(Loan loan, LoanDTO loanDTO) {
        // Implement the update logic
    	if (loanDTO.getConsumerName() != null) {
            loan.setConsumerName(loanDTO.getConsumerName());
        }
        if (loanDTO.getCurrentDate() != null) {
            loan.setCurrentDate(loanDTO.getCurrentDate());
        }
        if (loanDTO.getValidityDate() != null) {
            loan.setValidityDate(loanDTO.getValidityDate());
        }
        if (loanDTO.getReference() != null) {
            loan.setReference(loanDTO.getReference());
        }
    }
   }


