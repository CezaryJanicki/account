package com.kodilla.accounts.controller;

import com.kodilla.accounts.domain.AccountDto;
import com.kodilla.accounts.exception.AccountNotFoundException;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
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

    @DeleteMapping("accounts/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) throws AccountNotFoundException {
        try {
            accountService.deleteAccount(accountId);
        } catch (EmptyResultDataAccessException e) {
            throw new AccountNotFoundException();
        }
    }

    @PutMapping(value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) throws AccountNotFoundException {
        if (accountService.getAccount(accountDto.getId()).isPresent()) {
            return accountMapper.mapToAccountDto(accountService.saveAccount(accountMapper.mapToAccount(accountDto)));
        } else {
            throw new AccountNotFoundException();
        }
    }

    @PostMapping(value = "/accounts",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody AccountDto accountDto) {
        accountService.saveAccount(accountMapper.mapToAccount(accountDto));
    }
}
