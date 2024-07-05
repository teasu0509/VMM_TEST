package com.teasu.demo.service;

import com.teasu.demo.entity.User;

public interface UserService {
	User findByUsername(String username);
}
