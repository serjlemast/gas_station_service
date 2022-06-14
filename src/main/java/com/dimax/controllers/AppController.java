package com.dimax.controllers;

import com.dimax.entities.UserEntity;
import com.dimax.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping("/rest/v1")
@RequiredArgsConstructor
public class AppController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<Page<UserEntity>> getAllUsers(@PageableDefault(sort = {"name"})  //
                                                        Pageable pageable) {
        log.info("REST API: findLogs by : " + pageable);
        return ResponseEntity.ok(userRepository.findAll(pageable));
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        log.info("REST API: create new user : " + userEntity);
        return ResponseEntity.ok(userRepository.save(userEntity));
    }

    @ExceptionHandler
    public ResponseEntity<String> handleError(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) //
                .body(ex.getMessage());
    }

}
