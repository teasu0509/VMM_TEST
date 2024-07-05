package com.teasu.demo.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthorityEnum implements GrantedAuthority{
	ADMIN,USER,USER_CUSTOMER;

	@Override
	public String getAuthority() {
		return name();
	}
}
