package com.ticket.system.service;

import com.ticket.system.dto.PurchaseDTO;
import com.ticket.system.dto.PurchaseResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PurchaseService {
    public PurchaseResultDTO purchase(PurchaseDTO request) {
        try {
            Thread.sleep(1000);
            PurchaseResultDTO result = new PurchaseResultDTO();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("purchase error");
        }
        return null;
    }
}
