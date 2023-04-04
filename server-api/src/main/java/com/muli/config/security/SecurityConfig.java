package com.muli.config.security;

import com.muli.util.JwtTokenUtll;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sun.security.util.Password;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final JwtTokenUtll jwtTokenUtll;
//    private final UserDetailsService userDetailsService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin().disable();
        http.httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers("/user/login", "/user/password").permitAll()
                    .antMatchers("/user/list").hasAnyRole("USER")
                    .anyRequest().authenticated()
                    .and()
                    .addFilterBefore(new JwtAuthFilter(jwtTokenUtll), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    @Bean
//    AuthenticationProvider customAuthProvider() {
//        return new CustomAuthProvider(userDetailsService);
//    }
//
//    @Bean
//    AuthenticationManager authenticationManager() {
//        return new ProviderManager(customAuthProvider());
//    }
//
//    @Bean
//    CustomLoginFilter customLoginFilter() {
//        return new CustomLoginFilter(authenticationManager(), customSuccessHandler());
//    }
//
//    @Bean
//    CustomSuccessHandler customSuccessHandler() {
//        return new CustomSuccessHandler();
//    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
