package dev.mariocares.pasteleriacacu.controllers;

import dev.mariocares.pasteleriacacu.models.IngredienteForm;
import dev.mariocares.pasteleriacacu.models.IngredienteModel;
import dev.mariocares.pasteleriacacu.models.IngredienteTipoForm;
import dev.mariocares.pasteleriacacu.models.IngredienteTipoModel;
import dev.mariocares.pasteleriacacu.services.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class IngredienteController {
    @Autowired
    IngredienteService ingredienteService;

    @GetMapping(value = "/Ingrediente")
    public ModelAndView indexIngrediente(){
        return new ModelAndView("ingrediente/ingredientes")
                .addObject("Ingredientes", ingredienteService.obtenerIngredientes());
    }

    @GetMapping(value = "/Ingrediente/{id}")
    public ModelAndView ingrediente(@PathVariable Long id){
        ModelAndView respuesta;
        Optional<IngredienteModel> ingrediente = ingredienteService.obtener(id);
        respuesta = ingrediente
            .map(ingredienteModel -> new ModelAndView("ingrediente/ingrediente")
                .addObject("Ingrediente", ingrediente.get())
                .addObject("Tipos", ingredienteService.obtenerTipos())
                .addObject("formData", new IngredienteForm()))
            .orElseGet(() -> new ModelAndView("noEncuentro"));
        return respuesta;
    }

    @GetMapping(value = "/Ingrediente/Nuevo")
    public ModelAndView nuevoIngrediente(){
        return new ModelAndView("ingrediente/ingredienteNuevo")
            .addObject("formData", new IngredienteForm())
            .addObject("Tipos", ingredienteService.obtenerTipos());
    }

    @PostMapping(value = "/Ingrediente/Nuevo")
    public String guardarIngrediente(@Valid @ModelAttribute("formData") IngredienteForm formData,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "ingrediente/ingredienteNuevo";
        }
        ingredienteService.guardar(formData.toModel());
        return "redirect:/Ingrediente";
    }

    @PostMapping(value = "/Ingrediente/Editar")
    public String editarIngrediente(@Valid @ModelAttribute("formData") IngredienteForm formData,
                             BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "ingrediente/ingrediente";
        }
        ingredienteService.guardar(formData.toModel());
        return "redirect:/Ingrediente";
    }

    @PostMapping(value = "/Ingrediente/Eliminar")
    public String eliminarIngrediente(@RequestParam Long id){
        ingredienteService.eliminar(id);
        return "redirect:/Ingrediente";
    }

    // ------- TIPO INGREDIENTES
    @GetMapping(value = "/Ingrediente/Tipo")
    public ModelAndView indexTipo(){
        return new ModelAndView("ingrediente/tipos")
            .addObject("Tipos", ingredienteService.obtenerTipos());
    }

    @GetMapping(value = "/Ingrediente/Tipo/{id}")
    public ModelAndView tipo(@PathVariable Long id){
        ModelAndView respuesta;
        Optional<IngredienteTipoModel> tipo = ingredienteService.obtenerTipo(id);
        respuesta = tipo
            .map(ingredienteTipoModel -> new ModelAndView("ingrediente/tipo")
                .addObject("Tipo", ingredienteTipoModel)
                .addObject("formData", new IngredienteTipoForm()))
            .orElseGet(() -> new ModelAndView("noEncuentro"));
        return respuesta;
    }

    @GetMapping(value = "/Ingrediente/Tipo/Nuevo")
    public ModelAndView nuevoTipo(){
        return new ModelAndView("ingrediente/tipoNuevo")
            .addObject("formData", new IngredienteTipoForm());
    }

    @PostMapping(value = "/Ingrediente/Tipo/Nuevo")
    public String guardarTipo(@Valid @ModelAttribute("formData") IngredienteTipoForm formData,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "ingrediente/tipoNuevo";
        }
        ingredienteService.guardarTipo(formData.toModel());
        return "redirect:/Ingrediente/Tipo";
    }

    @PostMapping(value = "/Ingrediente/Tipo/Editar")
    public String editarTipo(@Valid @ModelAttribute("formData") IngredienteTipoForm formData,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "ingrediente/tipo";
        }
        ingredienteService.guardarTipo(formData.toModel());
        return "redirect:/Ingrediente/Tipo";
    }

    @PostMapping(value = "/Ingrediente/Tipo/Eliminar")
    public String eliminarTipo(@RequestParam Long id){
        ingredienteService.eliminarTipo(id);
        return "redirect:/Ingrediente/Tipo";
    }
}
