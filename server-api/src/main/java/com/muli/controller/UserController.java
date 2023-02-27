package com.muli.controller;

import com.common.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("name")
    private String getUserName(HttpServletRequest request){
        return "a";
    }

}
