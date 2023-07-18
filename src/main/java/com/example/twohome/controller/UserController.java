package com.example.twohome.controller;

import com.example.twohome.model.User;
import com.example.twohome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getFull() {
        return userService.getFull();
    }

    @GetMapping(value = "{id}")
    public User get(@PathVariable(value = "id") Long id) {
        return userService.get(id);
    }

}