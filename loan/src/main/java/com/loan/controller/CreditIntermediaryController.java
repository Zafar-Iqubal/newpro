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

import com.loan.dto.CreditIntermediaryDTO;
import com.loan.entities.CreditIntermediary;
import com.loan.service.CreditIntermediaryService;

@RestController
@RequestMapping("/api")
public class CreditIntermediaryController {
    private final CreditIntermediaryService creditIntermediaryService;

    @Autowired
    public CreditIntermediaryController(CreditIntermediaryService creditIntermediaryService) {
        this.creditIntermediaryService = creditIntermediaryService;
    }

    //http://localhost:8080/api/credit-intermediary
    @PostMapping("/credit-intermediary")
    public ResponseEntity<CreditIntermediary> createCreditIntermediary(@RequestBody CreditIntermediaryDTO creditIntermediaryDTO) {
        CreditIntermediary creditIntermediary = creditIntermediaryService.saveCreditIntermediary(creditIntermediaryDTO);
        return ResponseEntity.ok(creditIntermediary);
    }
    
    //http://localhost:8080/api/credit-intermediary/{id}
    @GetMapping("/credit-intermediary/{id}")
    public ResponseEntity<CreditIntermediary> getCreditIntermediary(@PathVariable Long id) {
        CreditIntermediary creditIntermediary = creditIntermediaryService.getCreditIntermediaryById(id);
        if (creditIntermediary != null) {
            return ResponseEntity.ok(creditIntermediary);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //http://localhost:8080/api/credit-intermediary/{id}
    @PutMapping("/credit-intermediary/{id}")
    public ResponseEntity<CreditIntermediary> updateCreditIntermediary(@PathVariable Long id, @RequestBody CreditIntermediaryDTO creditIntermediaryDTO) {
        CreditIntermediary updatedCreditIntermediary = creditIntermediaryService.updateCreditIntermediary(id, creditIntermediaryDTO);
        if (updatedCreditIntermediary != null) {
            return ResponseEntity.ok(updatedCreditIntermediary);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //http://localhost:8080/api/credit-intermediary/{id}
    @DeleteMapping("/credit-intermediary/{id}")
    public ResponseEntity<Void> deleteCreditIntermediary(@PathVariable Long id) {
        boolean deleted = creditIntermediaryService.deleteCreditIntermediary(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

