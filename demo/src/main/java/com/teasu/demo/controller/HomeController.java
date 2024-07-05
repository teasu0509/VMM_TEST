package com.teasu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teasu.demo.entity.User;
import com.teasu.demo.repository.UserRepository;

@RestController
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/members")
	public String createUser(@RequestBody User user) {
		// 加密密碼
		String encodePwd = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePwd);
		userRepository.save(user);
		return user.getId().toString();
	}
	
	@GetMapping("/members")
	public List<User> members() {
		return userRepository.findAll();
	}

	@GetMapping("/register")
	public String register() {
		return "註冊畫面";
	}

	@GetMapping("/home")
	public String home() {
		return "系統首頁";
	}

	@GetMapping("/user")
	public String user() {
		return "用戶中心";
	}

	@GetMapping("/userCustomer")
	public String userCustomer() {
		return "批發首頁";
	}

	
}
