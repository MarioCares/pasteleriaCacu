package dev.mariocares.pasteleriacacu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ingrediente {
    @GetMapping(value = "/Ingrediente/Tipo")
    public String index(){
        return "ingrediente/tipo";
    }

    @GetMapping(value = "/Ingrediente/Tipo/Nuevo")
    public String nuevo(){
        return "ingrediente/tipoNuevo";
    }
}
