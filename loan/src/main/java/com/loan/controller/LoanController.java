package com.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.dto.LoanDTO;
import com.loan.entities.Loan;
import com.loan.service.LoanService;

@RestController
@RequestMapping("/api")
public class LoanController {

	@Autowired
    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
 
    //http://localhost:8080/api/loan
    @PostMapping("/loan")
    public ResponseEntity<Loan> createLoan(@RequestBody LoanDTO loanDTO) {
        Loan loan = loanService.saveLoan(loanDTO);
        return ResponseEntity.ok(loan);
    }
    
    // http://localhost:8080/api/loan/{id}
    @GetMapping("/loan/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Loan loan = loanService.getLoanById(id);
        if (loan != null) {
            return ResponseEntity.ok(loan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //http://localhost:8080/api/loan/{id}
    @PutMapping("/loan/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody LoanDTO loanDTO) {
        Loan updatedLoan = loanService.updateLoan(id, loanDTO);
        if (updatedLoan != null) {
            return ResponseEntity.ok(updatedLoan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //http://localhost:8080/api/loan/{id}
    @DeleteMapping("/loan/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        boolean deleted = loanService.deleteLoan(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

