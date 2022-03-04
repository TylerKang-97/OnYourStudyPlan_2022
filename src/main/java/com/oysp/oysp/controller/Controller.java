package com.oysp.oysp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Controller {
    @GetMapping("/api")
    public String hello() {
        return "Hello Tyler!";
    }
}
