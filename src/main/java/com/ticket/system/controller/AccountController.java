package com.ticket.system.controller;

import com.ticket.system.dto.AccountDTO;
import com.ticket.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/account")
    public ResponseEntity<AccountDTO> getAccount(@RequestParam("accountNo") String accountNo) {
        AccountDTO accountDTO = accountService.getAccountInfoByAccountNo(accountNo);
        if (accountDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountDTO);
    }
}
