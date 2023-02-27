package com.common.service;

import com.common.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public String getUserName(){
        return "";
        /*userRepository.findAll();*/
    }

}
