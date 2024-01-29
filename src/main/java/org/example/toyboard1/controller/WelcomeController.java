package org.example.toyboard1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WelcomeController {

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }
}
