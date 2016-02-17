package com.aleshka.service;

import com.aleshka.domain.Account;
import com.aleshka.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService
{
    @Autowired
    private AccountRepository repository;

    @Transactional
    public Account save(Account account) {
        return repository.save(account);
    }

    public List<Account> findByCustomer(String customer) {
        return repository.findByCustomer(customer);
    }
}