package ambiental.sustentavel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class A {
    
    @GetMapping("/")
    public String hello(){
        return "olá mundo!";
    }
}
