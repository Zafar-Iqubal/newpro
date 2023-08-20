package com.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api")
public class ReportController {
    private final ReportService reportService;

        @Autowired
        public ReportController(ReportService reportService) {
            this.reportService = reportService;
        }
        
        //http://localhost:8080/api/report/loan/{loanId}
        @GetMapping("/report/loan/{loanId}")
        public ResponseEntity<byte[]> generateLoanReport(@PathVariable Long loanId) {
            try {
                byte[] reportBytes = reportService.generateLoanReport(loanId);
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("attachment", "loan_report.pdf");
                return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
            } catch (JRException e) {
                // Handle JasperReports exception
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        
        //http://localhost:8080/api/report/lender/{lenderId}
        @GetMapping("/report/lender/{lenderId}")
        public ResponseEntity<byte[]> generateLenderReport(@PathVariable Long lenderId) {
            try {
                byte[] reportBytes = reportService.generateLenderReport(lenderId);
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("attachment", "lender_report.pdf");
                return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
            } catch (JRException e) {
                // Handle JasperReports exception
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        
        //http://localhost:8080/api/report/credit-intermediary/{creditIntermediaryId}
        @GetMapping("/report/credit-intermediary/{creditIntermediaryId}")
        public ResponseEntity<byte[]> generateCreditIntermediaryReport(@PathVariable Long creditIntermediaryId) {
            try {
                byte[] reportBytes = reportService.generateCreditIntermediaryReport(creditIntermediaryId);
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("attachment", "credit_intermediary_report.pdf");
                return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
            } catch (JRException e) {
                // Handle JasperReports exception
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }


    // Similar endpoints for generating lender and credit intermediary reports

