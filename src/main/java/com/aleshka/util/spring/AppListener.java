package com.aleshka.util.spring;

import com.aleshka.domain.Account;
import com.aleshka.repository.AccountRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Date;

// Trash !!!
public class AppListener implements ApplicationListener<ContextRefreshedEvent>
{
    private boolean locked = false;

    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        if (locked) return;

        ApplicationContext context = event.getApplicationContext();
        AccountRepository accountRepository = (AccountRepository) context.getBean("accountRepository");

        accountRepository.saveAndFlush(new Account("Vasiliy", new Date()));
        accountRepository.saveAndFlush(new Account("Ivan", new Date()));
        accountRepository.saveAndFlush(new Account("Alex", new Date()));
        accountRepository.saveAndFlush(new Account("Petr", new Date()));
        accountRepository.saveAndFlush(new Account("Dzianis", new Date()));
        accountRepository.saveAndFlush(new Account("Ihar", new Date()));
        accountRepository.saveAndFlush(new Account("Slava", new Date()));
        accountRepository.saveAndFlush(new Account("Eugen", new Date()));
        accountRepository.saveAndFlush(new Account("Andrey", new Date()));
        accountRepository.saveAndFlush(new Account("Vitaliy", new Date()));

        locked = true;
    }
}
