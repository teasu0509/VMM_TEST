package com.teasu.demo.service;

import com.teasu.demo.entity.Member;

public interface UserService {
	Member findByAccount(String account);
}
