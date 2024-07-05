package com.teasu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teasu.demo.entity.Member;

public interface UserRepository extends JpaRepository<Member, String> {
	Member findByAccount(String account);
}
