package com.kodilla.accounts.mapper;

import com.kodilla.accounts.domain.Account;
import com.kodilla.accounts.domain.AccountDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    public Account mapToAccount(final AccountDto accountDto) {
        return new Account(accountDto.getId(), accountDto.getNrb(), accountDto.getCurrency(), accountDto.getAvailableFounds());
    }

    public AccountDto mapToAccountDto(final Account account) {
        return new AccountDto(account.getId(), account.getNrb(), account.getCurrency(), account.getAvailableFounds());
    }

    public List<AccountDto> mapToAccountDtoList(final List<Account> accountList) {
        return accountList.stream()
                .map(this::mapToAccountDto)
                .collect(Collectors.toList());
    }

    public List<Account> mapToAccountList(final List<AccountDto> accountDtoList) {
        return accountDtoList.stream()
                .map(this::mapToAccount)
                .collect(Collectors.toList());
    }
}

