package com.example.demo.security;

import com.example.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.formLogin(f -> f.loginPage("/login").successHandler(((request, response, authentication) -> response.sendRedirect("/movies"))).permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .userDetailsService(userDetailsService)
                .authorizeHttpRequests(a -> a
                        .requestMatchers("/movies/**","/actor/**","/assets/**","/register/**")
                        .permitAll()
                        .anyRequest().authenticated()).build();
    }
}
