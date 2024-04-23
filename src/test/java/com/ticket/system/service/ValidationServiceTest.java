package com.ticket.system.service;

import com.ticket.system.dto.AccountDTO;
import com.ticket.system.dto.PurchaseDTO;
import com.ticket.system.dto.SeatDTO;
import com.ticket.system.dto.ValidateResultDTO;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.ticket.system.entity.Account;
import com.ticket.system.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidationServiceTest {
    private PurchaseDTO purchaseDTO;

    private AccountDTO accountDTO;

    private SeatDTO seatDTO;

    @InjectMocks
    private ValidationService validationService;

    @BeforeEach
    public void setup() {
        this.purchaseDTO = PurchaseDTO.builder()
                .concertCode("abc")
                .accountNo("abc")
                .sessionCode("abc")
                .seatDTO(Arrays.asList(seatDTO))
                .build();
        this.accountDTO = AccountDTO.builder()
                .lastName("abc")
                .firstName("abc")
                .accountNo("abc")
                .build();
        this.seatDTO = SeatDTO.builder()
                .stage(SeatDTO.Stage.A)
                .concertCode("abc")
                .seatNo(3)
                .sessionCode("abc")
                .build();
    }

    @DisplayName("Valid validatePurchaseRequest")
    @Test
    void test_validatePurchaseRequest() {
        ValidateResultDTO validateResultDTO = validationService.validatePurchaseRequest(this.purchaseDTO);
        assertThat(validateResultDTO).isNotNull();
    }

    @DisplayName("Valid validateAccount")
    @Test
    void test_validateAccount() {
        ValidateResultDTO validateResultDTO = validationService.validateAccount(this.accountDTO);
        assertThat(validateResultDTO).isNotNull();
    }

    @DisplayName("Valid validateSeatAvailability")
    @Test
    void test_validateSeatAvailability() {
        ValidateResultDTO validateResultDTO = validationService.validateSeatAvailability(this.seatDTO);
        assertThat(validateResultDTO).isNotNull();
    }
}
