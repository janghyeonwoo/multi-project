package com.muli.service;

import com.common.respository.UserRepository;
import com.muli.dto.TokenInfo;
import com.muli.util.JwtTokenUtll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CustomMemberService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenUtll jwtTokenUtll;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenInfo login(String id, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenUtll.generateToken(authentication);
    }
}
