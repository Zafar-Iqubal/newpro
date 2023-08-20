package com.loan.service;

import com.loan.dto.LenderDTO;
import com.loan.entities.Lender;

public interface LenderService {
    Lender saveLender(LenderDTO lenderDTO);
    Lender getLenderById(Long id);
    Lender updateLender(Long id, LenderDTO lenderDTO);
    boolean deleteLender(Long id);
}