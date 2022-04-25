package dev.mariocares.pasteleriacacu.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class IngredienteForm {

    @NotNull(message = "El Ingrediente debe tener un nombre")
    @Size(min = 3, max = 255, message = "El Ingrediente debe tener un mínimo de 3 caracteres")
    private String nombre;

    private Long id;

    private IngredienteTipoModel tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IngredienteTipoModel getTipo() {
        return tipo;
    }

    public void setTipo(IngredienteTipoModel tipo) {
        this.tipo = tipo;
    }

    public IngredienteModel toModel(){
        return new IngredienteModel(this.id, this.nombre, this.tipo);
    }

    @Override
    public String toString() {
        return "IngredienteForm{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", tipo=" + tipo +
                '}';
    }
}
