package com.teasu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teasu.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByName(String name);
}
