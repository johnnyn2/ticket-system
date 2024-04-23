package com.ticket.system.service;

import com.ticket.system.dto.*;
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
public class PurchaseServiceTest {
    @InjectMocks
    private PurchaseService purchaseService;

    private PurchaseResultDTO purchaseResultDTO;

    private PurchaseDTO purchaseDTO;

    @BeforeEach
    public void setup() {
        SeatDTO seatDTO = SeatDTO.builder()
                .stage(SeatDTO.Stage.A)
                .concertCode("abc")
                .seatNo(3)
                .sessionCode("abc")
                .build();
        TicketDTO ticketDTO = TicketDTO.builder()
                .ticktNo("abc")
                .seat(seatDTO)
                .purchaseRef("abc")
                .lastName("abc")
                .firstName("abc")
                .concert(ConcertDTO.builder()
                        .startTime("2024-04-23T12:12:12")
                        .location("abc")
                        .endTime("2024-04-23T12:12:12")
                        .title("abc")
                        .district("Hung Hum")
                        .country("HK")
                        .build())
                .accountNo("abc")
                .build();
        purchaseResultDTO = PurchaseResultDTO.builder()
                .tickets(Arrays.asList(ticketDTO))
                .build();
        purchaseDTO = PurchaseDTO.builder()
                .concertCode("abc")
                .accountNo("abc")
                .sessionCode("abc")
                .seatDTO(Arrays.asList(seatDTO))
                .build();
    }

    @DisplayName("valid purchase")
    @Test
    void test_purchase() {
        PurchaseResultDTO purchaseResultDTO = purchaseService.purchase(this.purchaseDTO);
        assertThat(purchaseResultDTO).isNotNull();
    }
}
