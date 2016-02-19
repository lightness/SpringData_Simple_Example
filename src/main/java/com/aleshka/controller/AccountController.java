package com.aleshka.controller;

import com.aleshka.domain.Account;
import com.aleshka.repository.AccountRepository;
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
    public @ResponseBody Iterable<Account> getUsers()
    {
        return accountRepository.findAll();
    }

    @RequestMapping(value = "{size}/{page}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getUsersByPage(
            @PathVariable Integer page,
            @PathVariable Integer size)
    {
        return accountRepository.findAll(new PageRequest(page, size));
    }

    @RequestMapping(value = "sorted", method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getSortedUsers()
    {
        return accountRepository.findAllByOrderByCustomerAsc();
    }

    @RequestMapping(value = "/byCustomer/{customer}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Account> getUser(
            @PathVariable String customer)
    {
        return accountRepository.findByCustomer(customer);
    }
}
