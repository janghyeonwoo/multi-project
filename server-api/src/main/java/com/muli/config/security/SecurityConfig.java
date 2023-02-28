package com.muli.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.Security;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin().disable();
        http.authorizeRequests()
                .antMatchers("/psn/login").permitAll()
                .anyRequest().authenticated()
        .and()
        .addFilterBefore(customLoginFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    AuthenticationProvider customAuthProvider() {
        return new CustomAuthProvider(userDetailsService);
    }

    @Bean
    AuthenticationManager authenticationManager() {
        return new ProviderManager(customAuthProvider());
    }

    @Bean
    CustomLoginFilter customLoginFilter(){
        return new CustomLoginFilter(authenticationManager(),customSuccessHandler());
    }

    @Bean
    CustomSuccessHandler customSuccessHandler(){
        return new CustomSuccessHandler();
    }
}
