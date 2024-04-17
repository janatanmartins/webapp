package br.dev.janatandv.webApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController { 
    @GetMapping("/create")
    public String getCeateString() {
        return "create";
    }
    
    
}
