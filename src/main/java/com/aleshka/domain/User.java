package com.aleshka.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractPersistable<Long>
{
    private String name;


    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
