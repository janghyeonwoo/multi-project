package com.muli.config.security;

import com.muli.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;

@RequiredArgsConstructor
public class CustomAuthProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        UserInfo userInfo = (UserInfo) userDetailsService.loadUserByUsername(token.getName());
        if(!userInfo.getUser().getPassword().equals(token.getCredentials())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }

        return new UsernamePasswordAuthenticationToken(userInfo.getUser(),userInfo.getAuthorities(), Collections.singleton(new SimpleGrantedAuthority("PSN")));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
