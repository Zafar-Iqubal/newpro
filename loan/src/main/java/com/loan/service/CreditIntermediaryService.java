package com.loan.service;

import com.loan.dto.CreditIntermediaryDTO;
import com.loan.entities.CreditIntermediary;

public interface CreditIntermediaryService {
    CreditIntermediary saveCreditIntermediary(CreditIntermediaryDTO creditIntermediaryDTO);
    CreditIntermediary getCreditIntermediaryById(Long id);
    CreditIntermediary updateCreditIntermediary(Long id, CreditIntermediaryDTO creditIntermediaryDTO);
    boolean deleteCreditIntermediary(Long id);
}
