package com.ticket.system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.system.dto.AccountDTO;
import com.ticket.system.dto.ConcertDTO;
import com.ticket.system.service.AccountService;
import com.ticket.system.service.ConcertService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.eq;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ConcertController.class)
public class ConcertControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ConcertService concertService;

    @Test
    void whenMissingConcertCode() throws Exception {
        mockMvc.perform(
                        get("/concert")
                                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }
    @Test
    void whenInvalidInputAccountNo() throws Exception {
        mockMvc.perform(
                        get("/concert")
                                .contentType("application/json")
                                .param("code", "123"))
                .andExpect(status().isNotFound());
    }

    // mock business logic
    @Test
    void whenValidAccountNo() throws Exception {
        when(concertService.getConcertByCode(eq("abc"))).thenReturn(expectedConcertDTO());
        mockMvc.perform(
                        get("/concert")
                                .contentType("application/json")
                                .param("code", "abc"))
                .andExpect(status().isOk());
    }

    private ConcertDTO expectedConcertDTO() {
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
