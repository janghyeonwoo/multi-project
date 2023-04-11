package com.muli.controller;

import com.muli.dto.MemberLoginRequestDto;
import com.muli.dto.TokenInfo;
import com.muli.service.CustomMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final CustomMemberService customMemberService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    private TokenInfo login(@RequestBody MemberLoginRequestDto memberLoginRequestDto){
        String id = memberLoginRequestDto.getId();
        String password = memberLoginRequestDto.getPassword();
        return customMemberService.login(id,password);
    }

    @GetMapping("/password")
    private String getEncoderPassword(String val){
        return passwordEncoder.encode(val);
    }

    @GetMapping("/circuit_test")
    private String circuitTest(){
        return "OK!!";
    }


}
