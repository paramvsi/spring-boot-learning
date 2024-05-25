package com.example.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/", "/home").permitAll()  // Allow everyone to see the home page
                                .anyRequest().authenticated()  // Require authentication for any other request
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")  // Specify the custom login page URL
                                .permitAll()  // Allow all users to view the login page
                )
                .logout(logout ->
                        logout.permitAll()  // Allow all users to logout
                )
                .build();  // Build the SecurityFilterChain instance
    }
}
