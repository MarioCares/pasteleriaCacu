package dev.mariocares.pasteleriacacu.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class IngredienteTipoForm {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull(message = "El Tipo de Ingrediente debe tener un nombre")
    @Size(min = 3, max = 255, message = "El Tipo de Ingrediente debe tener un mínimo de 3 caracteres")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public IngredienteTipoForm() {
    }

    public IngredienteTipoForm(String nombre) {
        this.nombre = nombre;
    }

    public IngredienteTipoModel toModel(){
        return new IngredienteTipoModel(this.id, this.nombre);
    }

    @Override
    public String toString() {
        return "IngredienteTipoForm{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
