package com.teasu.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teasu.demo.entity.Member;
import com.teasu.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		Member member = userRepository.findByAccount(account);
		if (member == null) {
			throw new UsernameNotFoundException("查無此帳號:"+account);
		}
		
		List<SimpleGrantedAuthority> authorities = member.getAuthorities()
				.stream()
				.map(auth -> new SimpleGrantedAuthority(auth.name()))
				.toList();
		return User
                .withUsername(account)
                .password(member.getPassword())
                .authorities(authorities)
                .build()
				;
	}

}
