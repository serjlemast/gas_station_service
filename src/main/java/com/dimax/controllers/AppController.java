package com.dimax.controllers;

import com.dimax.entities.User;
import com.dimax.models.api.MyResponse;
import com.dimax.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest/v1")
@RequiredArgsConstructor
public class AppController {

    private final UserRepository repository;

    @GetMapping("/users")
    public ResponseEntity<MyResponse> getAllUsers() {
        List<User> users = repository.findAll();
        return ResponseEntity.ok(new MyResponse(users, users.size()));
    }

    @ExceptionHandler
    public ResponseEntity<String> handleError(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) //
                .body(ex.getMessage());
    }

}
