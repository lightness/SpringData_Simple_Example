package com.aleshka.util.spring;

import com.aleshka.domain.Account;
import com.aleshka.domain.User;
import com.aleshka.repository.AccountRepository;
import com.aleshka.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.GregorianCalendar;

// Trash !!!
public class AppListener implements ApplicationListener<ContextRefreshedEvent>
{
    private boolean locked = false;

    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        if (locked) return;

        ApplicationContext context = event.getApplicationContext();
        UserRepository userRepository = (UserRepository) context.getBean("userRepository");

        userRepository.saveAndFlush(new User("user_01"));
        userRepository.saveAndFlush(new User("user_02"));

        AccountRepository accountRepository = (AccountRepository) context.getBean("accountRepository");

        accountRepository.saveAndFlush(new Account("Vasiliy", new GregorianCalendar()));
        accountRepository.saveAndFlush(new Account("Ivan", new GregorianCalendar()));
        accountRepository.saveAndFlush(new Account("Alex", new GregorianCalendar()));
        accountRepository.saveAndFlush(new Account("Petr", new GregorianCalendar()));
        accountRepository.saveAndFlush(new Account("Dzianis", new GregorianCalendar()));
        accountRepository.saveAndFlush(new Account("Ihar", new GregorianCalendar()));
        accountRepository.saveAndFlush(new Account("Slava", new GregorianCalendar()));
        accountRepository.saveAndFlush(new Account("Eugen", new GregorianCalendar()));
        accountRepository.saveAndFlush(new Account("Andrey", new GregorianCalendar()));
        accountRepository.saveAndFlush(new Account("Vitaliy", new GregorianCalendar()));

        locked = true;
    }
}
