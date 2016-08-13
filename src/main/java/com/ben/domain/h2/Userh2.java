package com.ben.domain.h2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userh2")
public class Userh2 {

    @Id
    @GeneratedValue
    public int id;

    public String name;
}
