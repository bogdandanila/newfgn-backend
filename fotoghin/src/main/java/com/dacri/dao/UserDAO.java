package com.dacri.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.dacri.domain.User;
import com.dacri.domain.mapper.UserMapper;

@Repository
public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User findByEmail(String email) {
		User user = jdbcTemplate.queryForObject("select * from user where email=?", new Object[]{email}, new UserMapper());
		return user;
	}
}
