package com.ticket.system.service;

import com.ticket.system.dto.AccountDTO;
import com.ticket.system.entity.Account;
import com.ticket.system.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public AccountDTO getAccountInfoByAccountNo(String accountNo) {
        try {
            AccountDTO accountDTO = new AccountDTO();
            List<Account> accounts = accountRepository.findTop1ByAccountNo(accountNo);
            if (accounts.size() > 0) {
                Account account = accounts.get(0);
                log.info("Found account - accountNo: " + account.getAccountNo());
                BeanUtils.copyProperties(account, accountDTO);
                return accountDTO;
            }
            log.info("Not found account - accountNo: " + accountNo);
        } catch(Exception e) {
            log.error("Account Repository exception");
            e.printStackTrace();
        }
        return null;
    }
}
