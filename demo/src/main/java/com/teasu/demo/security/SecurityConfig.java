package com.teasu.demo.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.authorizeHttpRequests(request -> request
						.requestMatchers(HttpMethod.GET,"/register").permitAll()
						.requestMatchers(HttpMethod.POST,"/members").permitAll()
						.requestMatchers(HttpMethod.GET,"/members").permitAll()
						.requestMatchers(HttpMethod.GET,"/user").hasAnyAuthority("USER","ADMIN")
						.requestMatchers(HttpMethod.GET,"/userCustomer").hasAnyAuthority("USER_CUSTOMER","ADMIN")
//						.requestMatchers(HttpMethod.GET,"/members").hasAuthority("ADMIN")
						.anyRequest().authenticated() //登入後才能存取
						)
				.formLogin(Customizer.withDefaults())
				.csrf(csrf -> csrf.disable()) //呼叫 csrf 方法，可進一步停用對於「跨站請求偽造」（Cross-Site Request Forgery， CSRF）攻擊的保護機制。
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// 暫時 設定為密碼不加密
		return NoOpPasswordEncoder.getInstance();
	}
}
