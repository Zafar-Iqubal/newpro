package com.loan.serviceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.entities.CreditIntermediary;
import com.loan.entities.Lender;
import com.loan.entities.Loan;
import com.loan.repository.CreditIntermediaryRepository;
import com.loan.repository.LenderRepository;
import com.loan.repository.LoanRepository;
import com.loan.service.ReportService;
import com.loan.util.CustomDataSource;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ReportServiceImpl implements ReportService {
    private final LoanRepository loanRepository;
    private final LenderRepository lenderRepository;
    private final CreditIntermediaryRepository creditIntermediaryRepository;

    @Autowired
    public ReportServiceImpl(LoanRepository loanRepository, LenderRepository lenderRepository, CreditIntermediaryRepository creditIntermediaryRepository) {
        this.loanRepository = loanRepository;
        this.lenderRepository = lenderRepository;
        this.creditIntermediaryRepository = creditIntermediaryRepository;
    }

    @Override
    public byte[] generateLoanReport(Long loanId) throws JRException {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new EntityNotFoundException("Loan not found"));
        JasperReport jasperReport = JasperCompileManager.compileReport("classpath:reports/loanReport.jrxml");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("consumerName", loan.getConsumerName());

        // Create a list with your object (Loan in this case)
        List<Object> dataList = Collections.singletonList(loan);

        // Create your custom data source
        JRDataSource dataSource = new CustomDataSource(dataList);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    @Override
    public byte[] generateLenderReport(Long lenderId) throws JRException {
        Lender lender = lenderRepository.findById(lenderId).orElseThrow(() -> new EntityNotFoundException("Lender not found"));
        JasperReport jasperReport = JasperCompileManager.compileReport("classpath:reports/lenderReport.jrxml");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("lenderName", lender.getName());

        // Create a list with your object (Lender in this case)
        List<Object> dataList = Collections.singletonList(lender);

        // Create your custom data source
        JRDataSource dataSource = new CustomDataSource(dataList);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    @Override
    public byte[] generateCreditIntermediaryReport(Long creditIntermediaryId) throws JRException {
        CreditIntermediary intermediary = creditIntermediaryRepository.findById(creditIntermediaryId).orElseThrow(() -> new EntityNotFoundException("Credit Intermediary not found"));
        JasperReport jasperReport = JasperCompileManager.compileReport("classpath:reports/creditIntermediaryReport.jrxml");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("intermediaryName", intermediary.getCompanyName());

        // Create a list with your object (CreditIntermediary in this case)
        List<Object> dataList = Collections.singletonList(intermediary);

        // Create your custom data source
        JRDataSource dataSource = new CustomDataSource(dataList);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
