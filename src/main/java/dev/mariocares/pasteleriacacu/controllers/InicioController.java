package dev.mariocares.pasteleriacacu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping(value = "/")
    public String nueva(){
        return "index";
    }
}
