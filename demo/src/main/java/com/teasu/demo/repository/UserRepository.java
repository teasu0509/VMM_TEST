package com.teasu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teasu.demo.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String account);
}
