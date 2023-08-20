package com.loan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.dto.CreditIntermediaryDTO;
import com.loan.entities.CreditIntermediary;
import com.loan.repository.CreditIntermediaryRepository;
import com.loan.service.CreditIntermediaryService;

@Service
public class CreditIntermediaryServiceImpl implements CreditIntermediaryService {
    private final CreditIntermediaryRepository creditIntermediaryRepository;

    @Autowired
    public CreditIntermediaryServiceImpl(CreditIntermediaryRepository creditIntermediaryRepository) {
        this.creditIntermediaryRepository = creditIntermediaryRepository;
    }

    @Override
    public CreditIntermediary saveCreditIntermediary(CreditIntermediaryDTO creditIntermediaryDTO) {
        CreditIntermediary creditIntermediary = convertToCreditIntermediaryEntity(creditIntermediaryDTO);
        return creditIntermediaryRepository.save(creditIntermediary);
    }

    @Override
    public CreditIntermediary getCreditIntermediaryById(Long id) {
        return creditIntermediaryRepository.findById(id).orElse(null);
    }

    @Override
    public CreditIntermediary updateCreditIntermediary(Long id, CreditIntermediaryDTO creditIntermediaryDTO) {
        CreditIntermediary existingCreditIntermediary = creditIntermediaryRepository.findById(id).orElse(null);
        if (existingCreditIntermediary != null) {
            updateCreditIntermediaryEntity(existingCreditIntermediary, creditIntermediaryDTO);
            return creditIntermediaryRepository.save(existingCreditIntermediary);
        }
        return null;
    }

    @Override
    public boolean deleteCreditIntermediary(Long id) {
        CreditIntermediary existingCreditIntermediary = creditIntermediaryRepository.findById(id).orElse(null);
        if (existingCreditIntermediary != null) {
            creditIntermediaryRepository.delete(existingCreditIntermediary);
            return true;
        }
        return false;
    }

    private CreditIntermediary convertToCreditIntermediaryEntity(CreditIntermediaryDTO creditIntermediaryDTO) {
        CreditIntermediary creditIntermediary = new CreditIntermediary();
        creditIntermediary.setCompanyName(creditIntermediaryDTO.getCompanyName());
        creditIntermediary.setTelephoneNumber(creditIntermediaryDTO.getTelephoneNumber());
        creditIntermediary.setAddress(creditIntermediaryDTO.getAddress());
        creditIntermediary.setBrokerName(creditIntermediaryDTO.getBrokerName());
        creditIntermediary.setBrokerCommission(creditIntermediaryDTO.getBrokerCommission());
        creditIntermediary.setNetworkName(creditIntermediaryDTO.getNetworkName());
        creditIntermediary.setMortgageClubName(creditIntermediaryDTO.getMortgageClubName());
        return creditIntermediary;
    }

    private void updateCreditIntermediaryEntity(CreditIntermediary creditIntermediary, CreditIntermediaryDTO creditIntermediaryDTO) {
        if (creditIntermediaryDTO.getCompanyName() != null) {
            creditIntermediary.setCompanyName(creditIntermediaryDTO.getCompanyName());
        }
        if (creditIntermediaryDTO.getTelephoneNumber() != null) {
            creditIntermediary.setTelephoneNumber(creditIntermediaryDTO.getTelephoneNumber());
        }
        if (creditIntermediaryDTO.getAddress() != null) {
            creditIntermediary.setAddress(creditIntermediaryDTO.getAddress());
        }
        if (creditIntermediaryDTO.getBrokerName() != null) {
            creditIntermediary.setBrokerName(creditIntermediaryDTO.getBrokerName());
        }
        if (creditIntermediaryDTO.getBrokerCommission() != null) {
            creditIntermediary.setBrokerCommission(creditIntermediaryDTO.getBrokerCommission());
        }
        if (creditIntermediaryDTO.getNetworkName() != null) {
            creditIntermediary.setNetworkName(creditIntermediaryDTO.getNetworkName());
        }
        if (creditIntermediaryDTO.getMortgageClubName() != null) {
            creditIntermediary.setMortgageClubName(creditIntermediaryDTO.getMortgageClubName());
        }
    }
}
