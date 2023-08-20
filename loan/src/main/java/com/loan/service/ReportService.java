package com.loan.service;

import net.sf.jasperreports.engine.JRException;

public interface ReportService {
    
        byte[] generateLoanReport(Long loanId) throws JRException;
        byte[] generateLenderReport(Long lenderId) throws JRException;
        byte[] generateCreditIntermediaryReport(Long creditIntermediaryId) throws JRException;


    
    // Add similar methods for generating lender and credit intermediary reports
}