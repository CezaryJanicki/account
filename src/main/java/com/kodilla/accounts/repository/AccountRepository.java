package com.kodilla.accounts.repository;

import com.kodilla.accounts.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findById(Long id);

    Account getAccountById(Long account);

    @Override
    List<Account> findAll();
}
