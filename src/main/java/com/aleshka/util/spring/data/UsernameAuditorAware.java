package com.aleshka.util.spring.data;

import com.aleshka.domain.User;
import com.aleshka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;


@Component
public class UsernameAuditorAware implements AuditorAware<User>
{
    @Autowired
    private UserRepository userRepository;


    // !!! Stub implementation. Highly recommended to use spring security authentication info
    public User getCurrentAuditor()
    {
        return userRepository.findOne(1L);
    }
}
