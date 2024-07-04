package com.teasu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teasu.entity.User;
import com.teasu.repository.UserRepository;
import com.teasu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByName(username);
	}
}
