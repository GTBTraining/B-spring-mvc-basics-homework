package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginErrorException;
import com.thoughtworks.capacity.gtb.mvc.exception.NameAlreadyExitException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser (@Valid @RequestBody User user) throws NameAlreadyExitException {
        userService.registerUser(user);
    }

    @GetMapping("/login")
    public User login (@RequestParam @Valid String username,String password) throws LoginErrorException {
        return userService.loginUser(username,password);
    }
}
