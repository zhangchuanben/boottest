package com.ben.domain.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	private int id;
	private String name;
	private int age;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "ID_")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "AGE_")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
