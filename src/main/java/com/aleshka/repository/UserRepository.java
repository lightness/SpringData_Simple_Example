package com.aleshka.repository;

import com.aleshka.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long>
{
}
