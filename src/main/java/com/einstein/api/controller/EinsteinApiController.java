package com.einstein.api.controller;

import com.einstein.api.model.SignupRequest;
import com.einstein.api.model.User;
import com.einstein.api.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class EinsteinApiController {

    private final UsersRepository usersRepository;


    @PostMapping("/sign-up")
    @CrossOrigin(origins = "http://localhost:3000")
    public void signUp(@RequestBody SignupRequest signupRequest) {
        User user = new User();
        user.setUserId(signupRequest.getUserId());
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        log.info("Request {}",signupRequest);
        usersRepository.save(user);
    }


}
