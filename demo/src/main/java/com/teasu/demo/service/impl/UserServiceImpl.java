package com.teasu.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teasu.demo.entity.Member;
import com.teasu.demo.repository.UserRepository;
import com.teasu.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Member findByAccount(String account) {
		return userRepository.findByAccount(account);
	}
}
