package com.teasu.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/error").permitAll() // 允許訪問首頁、登入頁面和錯誤頁面
                .anyRequest().authenticated() // 其他請求需要認證才能訪問
            )
            .formLogin(form -> form
                .loginPage("/login") // 自定義登入頁面
                .defaultSuccessUrl("/", true) // 登入成功後跳轉到首頁
                .permitAll() // 允許所有人訪問登入頁面
            )
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 自定義登出路徑
                .logoutSuccessUrl("/login?logout") // 登出成功後跳轉到登入頁面
                .permitAll() // 允許所有人訪問登出頁面
            );
        return http.build();
    }
}

