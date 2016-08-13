package com.ben.dao.mysql;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ben.domain.mysql.Person;

@Transactional
public interface PersonDao extends JpaRepository<Person, Integer>{
	Person getById(int userId);
	List<Person> findAll();
}
