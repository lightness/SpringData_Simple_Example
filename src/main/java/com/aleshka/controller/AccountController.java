package com.aleshka.controller;

import com.aleshka.domain.Account;
import com.aleshka.repository.AccountRepository;
import com.aleshka.repository.specification.AccountSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/accounts")
public class AccountController
{
    @Autowired
    private AccountRepository accountRepository;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getAccounts()
    {
        return accountRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody Account getAccount(
        @PathVariable Long id)
    {
        return accountRepository.findOne(id);
    }

    @RequestMapping(value = "{size}/{page}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getAccountsByPage(
            @PathVariable Integer page,
            @PathVariable Integer size)
    {
        return accountRepository.findAll(new PageRequest(page, size));
    }

    @RequestMapping(value = "sorted", method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getSortedAccounts()
    {
        return accountRepository.findAllByOrderByCustomerAsc();
    }

    @RequestMapping(value = "byCustomer/{customer}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getAccount(
            @PathVariable String customer)
    {
        return accountRepository.findByCustomer(customer);
    }

    @RequestMapping(value = "search/odd", method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getAccountsWithOddId()
    {
        return accountRepository.findAllWithOddId();
    }

    @RequestMapping(value = "{id}/update/customer/{customer}", method = RequestMethod.GET)
    public @ResponseBody String updateAccount(
            @PathVariable Long id,
            @PathVariable String customer)
    {
        accountRepository.updateCustomerById(id, customer);
        return "updated";
    }

    @RequestMapping(value = "search/{term}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getAccountBySearchTerm(
            @PathVariable String term)
    {
        return accountRepository.findBySearchTerm(term);
    }

    @RequestMapping(value = "search/criteria/{term}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getAccountByStartAndEndTerms(
            @PathVariable String term)
    {
        return accountRepository.findAll(AccountSpecs.isCustomerContains(term));
    }
}
