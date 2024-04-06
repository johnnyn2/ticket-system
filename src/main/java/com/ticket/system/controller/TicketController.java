package com.ticket.system.controller;

import com.ticket.system.dto.*;
import com.ticket.system.service.PurchaseService;
import com.ticket.system.service.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
public class TicketController {
    @Autowired
    private ValidationService validationService;

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/validate/purchase")
    public ResponseEntity<ValidateResultDTO> validatePurchaseRequest(@RequestBody PurchaseDTO request) {
        return ResponseEntity.ok(validationService.validatePurchaseRequest(request));
    }

    @PostMapping("/validate/account")
    public ResponseEntity<ValidateResultDTO> validateAccount(@RequestBody AccountDTO request) {
        return ResponseEntity.ok(validationService.validateAccount(request));
    }

    @PostMapping("/validate/seat")
    public ResponseEntity<ValidateResultDTO> validateSeatAvailability(@RequestBody SeatDTO request) {
        return ResponseEntity.ok(validationService.validateSeatAvailability(request));
    }

    @PostMapping("/purchase/ticket")
    public ResponseEntity<PurchaseResultDTO> purchaseTicket(@RequestBody PurchaseDTO request) {
        return ResponseEntity.ok(purchaseService.purchase(request));
    }
}
