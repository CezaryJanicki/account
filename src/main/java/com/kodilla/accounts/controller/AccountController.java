package com.kodilla.accounts.controller;

import com.kodilla.accounts.domain.AccountDto;
import com.kodilla.accounts.exception.AccountNotFoundException;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/accounts")
    public List<AccountDto> getAccounts() {
        return accountMapper.mapToAccountDtoList(accountService.getAllAccounts());
    }

    @GetMapping("accounts/{accountId}")
    public AccountDto getAccount(@PathVariable Long accountId) throws AccountNotFoundException {
        return accountMapper.mapToAccountDto(accountService.getAccount(accountId).orElseThrow(AccountNotFoundException::new));
    }
}
