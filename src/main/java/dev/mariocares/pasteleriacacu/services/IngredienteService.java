package dev.mariocares.pasteleriacacu.services;

import dev.mariocares.pasteleriacacu.models.IngredienteModel;
import dev.mariocares.pasteleriacacu.models.IngredienteTipoModel;
import dev.mariocares.pasteleriacacu.repositories.IngredienteRepository;
import dev.mariocares.pasteleriacacu.repositories.IngredienteTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredienteService {
    @Autowired
    IngredienteTipoRepository ingredienteTipoRepository;
    @Autowired
    IngredienteRepository ingredienteRepository;

    public Optional<IngredienteModel> obtener(Long id){
        return ingredienteRepository.findById(id);
    }

    public Iterable<IngredienteModel> obtenerIngredientes(){
        return ingredienteRepository.findAll();
    }

    public void guardar(IngredienteModel ingrediente){
        ingredienteRepository.save(ingrediente);
    }

    public void eliminar(Long id){
        ingredienteRepository.deleteById(id);
    }

    // ------- TIPO INGREDIENTE

    public Optional<IngredienteTipoModel> obtenerTipo(Long id){
        return ingredienteTipoRepository.findById(id);
    }

    public Iterable<IngredienteTipoModel> obtenerTipos(){
        return ingredienteTipoRepository.findAll();
    }

    public void guardarTipo(IngredienteTipoModel ingredienteTipo){
        ingredienteTipoRepository.save(ingredienteTipo);
    }

    public void eliminarTipo(Long id){
        ingredienteTipoRepository.deleteById(id);
    }
}
