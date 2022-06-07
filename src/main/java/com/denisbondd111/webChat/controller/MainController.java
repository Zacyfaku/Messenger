package com.denisbondd111.webChat.controller;

import com.denisbondd111.webChat.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController("/")
public class MainController{
    private static HashMap<String, User> userRepo = new HashMap<>();

    static {
        User user1 = new User(1L, "John", 25);
        userRepo.put(String.valueOf(user1.getId()), user1);
        User user2 = new User(2L, "Honor", 30);
        userRepo.put(String.valueOf(user2.getId()), user2);
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getUsers(){
        return new ResponseEntity<Object>(userRepo.values(), HttpStatus.OK);
    }
}
