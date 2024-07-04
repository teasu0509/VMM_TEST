package com.teasu.service;

import com.teasu.entity.User;

public interface UserService {
	User findByUsername(String username);
}
