package com.dacri.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dacri.dao.UserDAO;
import com.dacri.domain.User;

@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

	@Autowired
	private UserDAO userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String login) {

		log.debug("Authenticating {}", login);
		String lowercaseLogin = login.toLowerCase();

		User userFromDatabase = null;
		if (lowercaseLogin.contains("@")) {
			userFromDatabase = userRepository.findByEmail(lowercaseLogin);
		}

		if (userFromDatabase == null) {
			throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
		}

		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userFromDatabase.getRole());
		
		grantedAuthorities.add(grantedAuthority);
		return new org.springframework.security.core.userdetails.User(userFromDatabase.getEmail(),
				userFromDatabase.getPassword(), grantedAuthorities);

	}

}