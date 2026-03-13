package com.eterni.dimp.assistantapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cqkir
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "assistant-api started";
    }
}
