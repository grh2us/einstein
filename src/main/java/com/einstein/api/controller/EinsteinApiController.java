package com.einstein.api.controller;

import com.einstein.api.model.LoginRequest;
import com.einstein.api.model.User;
import com.einstein.api.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class EinsteinApiController {

    private final UsersRepository usersRepository;


    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
        User user = new User();
        user.setUserName(loginRequest.getUserId());
        log.info("Request {}",loginRequest);
        usersRepository.save(user);
    }


}
