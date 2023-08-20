package com.loan.service;

import com.loan.dto.LoanDTO;
import com.loan.entities.Loan;

public interface LoanService {
    Loan saveLoan(LoanDTO loanDTO);
    Loan getLoanById(Long id);
    Loan updateLoan(Long id, LoanDTO loanDTO);
    boolean deleteLoan(Long id);
}
