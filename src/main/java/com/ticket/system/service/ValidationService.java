package com.ticket.system.service;

import com.ticket.system.dto.AccountDTO;
import com.ticket.system.dto.PurchaseDTO;
import com.ticket.system.dto.SeatDTO;
import com.ticket.system.dto.ValidateResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ValidationService {
    public ValidateResultDTO validatePurchaseRequest(PurchaseDTO request) {
        try {
            Thread.sleep(1000);
            ValidateResultDTO result = new ValidateResultDTO();
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("validatePurchaseRequest error");
        }
        return null;
    }

    public ValidateResultDTO validateAccount(AccountDTO request) {
        try {
            Thread.sleep(1000);
            ValidateResultDTO result = new ValidateResultDTO();
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("validateAccount error");
        }
        return null;
    }

    public ValidateResultDTO validateSeatAvailability(SeatDTO request) {
        try {
            Thread.sleep(1000);
            ValidateResultDTO result = new ValidateResultDTO();
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("validateSeatAvailability error");
        }
        return null;
    }
}
