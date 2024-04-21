package com.ticket.system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.system.dto.*;
import com.ticket.system.service.PurchaseService;
import com.ticket.system.service.ValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TicketController.class)
public class TicketControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ValidationService validationService;

    @MockBean
    private PurchaseService purchaseService;

    @Test
    void whenValidValidatePurchaseRequest() throws Exception {
        when(validationService.validatePurchaseRequest(eq(purchaseDTORequest())))
                .thenReturn(expectedValidateResultDTO());
        mockMvc.perform(
                post("/validate/purchase")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(purchaseDTORequest())))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidValidateAccount() throws Exception {
        when(validationService.validateAccount(eq(accountDTORequest())))
                .thenReturn(expectedValidateResultDTO());
        mockMvc.perform(
                post("/validate/account")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(accountDTORequest()))
        ).andExpect(status().isOk());
    }

    @Test
    void whenValidValidateSeatAvailability() throws Exception {
        when(validationService.validateSeatAvailability(eq(seatDTORequest()))).thenReturn(expectedValidateResultDTO());
        mockMvc.perform(
                post("/validate/seat")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(seatDTORequest()))
        ).andExpect(status().isOk());
    }

    @Test
    void whenValidValidatePurchaseTicket() throws Exception {
        when(purchaseService.purchase(eq(purchaseDTORequest()))).thenReturn(expectedPurchaseResultDTO());
        mockMvc.perform(
                post("/purchase/ticket")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(purchaseDTORequest()))
        ).andExpect(status().isOk());
    }

    private PurchaseDTO purchaseDTORequest() {
        SeatDTO seatDTO = SeatDTO.builder()
                .seatNo(3)
                .stage(SeatDTO.Stage.A)
                .concertCode("abc")
                .sessionCode("abc")
                .build();
        return PurchaseDTO.builder()
                .seatDTO(Arrays.asList(seatDTO))
                .sessionCode("abc")
                .accountNo("abc")
                .concertCode("abc")
                .build();
    }

    private ValidateResultDTO expectedValidateResultDTO() {
        return ValidateResultDTO.builder()
                .success(true).build();
    }
    private AccountDTO accountDTORequest() {
        return AccountDTO.builder()
                .accountNo("7299")
                .firstName("Johnny")
                .lastName("Ho")
                .build();
    }

    private SeatDTO seatDTORequest() {
        return SeatDTO.builder()
                .sessionCode("abc")
                .seatNo(12)
                .concertCode("abc")
                .stage(SeatDTO.Stage.A)
                .build();
    }

    private PurchaseResultDTO expectedPurchaseResultDTO() {
        TicketDTO ticketDTO = TicketDTO.builder()
                .accountNo("abc")
                .concert(concertDTO())
                .firstName("abc")
                .lastName("abc")
                .purchaseRef("abc")
                .seat(seatDTORequest())
                .ticktNo("abc")
                .build();
        return PurchaseResultDTO.builder()
                .tickets(Arrays.asList(ticketDTO)).build();
    }

    private ConcertDTO concertDTO() {
        return ConcertDTO.builder()
                .title("title")
                .country("country")
                .district("district")
                .endTime("2024-04-21T12:12:12")
                .location("HK")
                .startTime("2024-04-21T12:12:12")
                .build();
    }
}
