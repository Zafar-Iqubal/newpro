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

import com.loan.dto.LenderDTO;
import com.loan.entities.Lender;
import com.loan.service.LenderService;

@RestController
@RequestMapping("/api")
public class LenderController {
    private final LenderService lenderService;

    @Autowired
    public LenderController(LenderService lenderService) {
        this.lenderService = lenderService;
    }

    //http://localhost:8080/api/lender
    @PostMapping("/lender")
    public ResponseEntity<Lender> createLender(@RequestBody LenderDTO lenderDTO) {
        Lender lender = lenderService.saveLender(lenderDTO);
        return ResponseEntity.ok(lender);
    }
  
    //http://localhost:8080/api/lender/{id}
    @GetMapping("/lender/{id}")
    public ResponseEntity<Lender> getLender(@PathVariable Long id) {
        Lender lender = lenderService.getLenderById(id);
        if (lender != null) {
            return ResponseEntity.ok(lender);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //http://localhost:8080/api/lender/{id}
    @PutMapping("/lender/{id}")
    public ResponseEntity<Lender> updateLender(@PathVariable Long id, @RequestBody LenderDTO lenderDTO) {
        Lender updatedLender = lenderService.updateLender(id, lenderDTO);
        if (updatedLender != null) {
            return ResponseEntity.ok(updatedLender);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //http://localhost:8080/api/lender/{id}
    @DeleteMapping("/lender/{id}")
    public ResponseEntity<Void> deleteLender(@PathVariable Long id) {
        boolean deleted = lenderService.deleteLender(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

