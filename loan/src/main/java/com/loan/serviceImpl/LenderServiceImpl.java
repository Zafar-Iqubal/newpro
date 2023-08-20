package com.loan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.dto.LenderDTO;
import com.loan.entities.Lender;
import com.loan.repository.LenderRepository;
import com.loan.service.LenderService;

@Service
public class LenderServiceImpl implements LenderService {
    private final LenderRepository lenderRepository; // You'll need to define this repository

    @Autowired
    public LenderServiceImpl(LenderRepository lenderRepository) {
        this.lenderRepository = lenderRepository;
    }

    @Override
    public Lender saveLender(LenderDTO lenderDTO) {
        // Convert LenderDTO to Lender entity and save it using the repository
        Lender lender = convertToLenderEntity(lenderDTO);
        return lenderRepository.save(lender);
    }

    @Override
    public Lender getLenderById(Long id) {
        return lenderRepository.findById(id).orElse(null);
    }

    @Override
    public Lender updateLender(Long id, LenderDTO lenderDTO) {
        Lender existingLender = lenderRepository.findById(id).orElse(null);
        if (existingLender != null) {
            // Update existingLender with data from lenderDTO and save
            updateLenderEntity(existingLender, lenderDTO);
            return lenderRepository.save(existingLender);
        }
        return null; // Return null if lender with given id is not found
    }

    @Override
    public boolean deleteLender(Long id) {
        Lender existingLender = lenderRepository.findById(id).orElse(null);
        if (existingLender != null) {
            lenderRepository.delete(existingLender);
            return true;
        }
        return false; // Return false if lender with given id is not found
    }

    // You would need to define methods to convert between LenderDTO and Lender entity
    private Lender convertToLenderEntity(LenderDTO lenderDTO) {
        // Implement the conversion logic
    	Lender lender = new Lender();
        lender.setName(lenderDTO.getName());
        lender.setTelephoneNumber(lenderDTO.getTelephoneNumber());
        lender.setAddress(lenderDTO.getAddress());
        return lender;
    }

    private void updateLenderEntity(Lender lender, LenderDTO lenderDTO) {
        // Implement the update logic
    	if (lenderDTO.getName() != null) {
            lender.setName(lenderDTO.getName());
        }
        if (lenderDTO.getTelephoneNumber() != null) {
            lender.setTelephoneNumber(lenderDTO.getTelephoneNumber());
        }
        if (lenderDTO.getAddress() != null) {
            lender.setAddress(lenderDTO.getAddress());
        }
    
    }
}
