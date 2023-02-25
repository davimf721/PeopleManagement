package com.peopleManagement.davi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping
public class HealthyController {
    @GetMapping("/")
    public ResponseEntity<String> heathyCheck() {
        return new ResponseEntity<>("Tudo certo por aqui!", HttpStatus.OK);
    }

}