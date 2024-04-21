package com.ticket.system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.system.dto.AccountDTO;
import com.ticket.system.service.AccountService;
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
@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AccountService accountService;

    @Test
    void whenMissingInputAccountNo() throws Exception {
        mockMvc.perform(
                get("/account")
                        .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenInvalidInputAccountNo() throws Exception {
        mockMvc.perform(
                get("/account")
                        .contentType("application/json")
                        .param("accountNo", "123"))
                .andExpect(status().isNotFound());
    }

    // mock business logic
    @Test
    void whenValidAccountNo() throws Exception {
        when(accountService.getAccountInfoByAccountNo(eq("7299"))).thenReturn(expectedAccountDTO());
        mockMvc.perform(
                        get("/account")
                                .contentType("application/json")
                                .param("accountNo", "7299"))
                .andExpect(status().isOk());
    }

    private AccountDTO expectedAccountDTO() {
        return AccountDTO.builder()
                .accountNo("7299")
                .firstName("Johnny")
                .lastName("Ho")
                .build();
    }
}
