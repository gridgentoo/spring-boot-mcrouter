package com.mcrouter.app.controller;

import com.mcrouter.app.domain.User;
import com.mcrouter.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<User> find(@RequestParam String name) {
        return ResponseEntity.ok(userService.findUser(name));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody String name) {
        return ResponseEntity.ok(userService.createUser(name));
    }
}
