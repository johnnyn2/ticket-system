package com.ticket.system.service;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.ticket.system.dto.AccountDTO;
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
public class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account account;

    @BeforeEach
    public void setup() {
        account = Account.builder()
                .accountNo("abc")
                .id("abc")
                .createdOn(new Date())
                .firstName("abc")
                .lastName("abc")
                .modifiedOn(new Date())
                .build();
    }

    @DisplayName("Found account by accountNo")
    @Test
    public void test_getAccountInfoByAccountNo_found() {
        given(accountRepository.findTop1ByAccountNo(account.getAccountNo()))
                .willReturn(Arrays.asList(account));
        AccountDTO accountDTO = accountService.getAccountInfoByAccountNo(account.getAccountNo());
        assertThat(accountDTO).isNotNull();
    }

    @DisplayName("Not found account by accountNo")
    @Test
    public void test_getAccountInfoByAccountNo_not_found() {
        given(accountRepository.findTop1ByAccountNo(account.getAccountNo()))
                .willReturn(Arrays.asList());
        AccountDTO accountDTO = accountService.getAccountInfoByAccountNo(account.getAccountNo());
        assertThat(accountDTO).isNull();
    }

    @DisplayName("Repository layer exception")
    @Test
    public void test_getAccountInfoByAccountNo_exception() {
        when(accountRepository.findTop1ByAccountNo(eq(account.getAccountNo())))
                .thenThrow();
        AccountDTO accountDTO = accountService.getAccountInfoByAccountNo(account.getAccountNo());
        assertThat(accountDTO).isNull();
    }
}
