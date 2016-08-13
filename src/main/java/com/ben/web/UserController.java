package com.ben.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ben.dao.mysql.PersonDao;
import com.ben.domain.mysql.Person;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PersonDao personDao;
	// 这里必须用userId才能正确获取到
	@RequestMapping(value = "/{userId}", method=RequestMethod.GET)
	public Map<String, Object> getUser(@PathVariable Long userId) {
		return jdbcTemplate.queryForMap("SELECT * FROM `person` WHERE id_ =?", userId);
	}
	
	
	@RequestMapping(value = "/getAll")
	public List<Person> getAll() {
		personDao.findAll().forEach(System.out::println);
		return personDao.findAll();
	}
}
