package com.ben.domain.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usermysql")
public class UserMysql{

    @Id
    @GeneratedValue
    public int id;

    public String name;

}
