package com.aleshka.controller;

import com.aleshka.domain.Account;
import com.aleshka.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
public class AccountController
{
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public @ResponseBody List<Account> getUsersRest() {
        Account account = new Account();
        account.setCustomer("Vasya");
        account.setExpiryDate(new Date());
        accountService.save(account);
        return accountService.findByCustomer("Vasya");
    }
}
