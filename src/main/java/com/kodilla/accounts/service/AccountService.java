package com.kodilla.accounts.service;

import com.kodilla.accounts.domain.Account;
import com.kodilla.accounts.domain.AccountDto;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    public Optional<Account> getAccount(final Long id) {
        return accountRepository.findById(id);
    }

    public Account getAccountById(final Long id) {
        return accountRepository.getAccountById(id);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account saveAccount(final Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(long accountId) {
        accountRepository.deleteById(accountId);
    }

    public List<AccountDto> getAccountsForCustomer(Long customerId) {
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        return accountMapper.mapToAccountDtoList(accounts);
    }
}
