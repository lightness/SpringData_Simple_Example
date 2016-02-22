package com.aleshka.util.spring.data;

import org.springframework.data.domain.AuditorAware;


public class UsernameAuditorAware implements AuditorAware<String>
{
    // !!! Stub implementation. Highly recommended to use spring security authentication info
    public String getCurrentAuditor()
    {
        return "Zloy admin";
    }
}
