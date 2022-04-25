package dev.mariocares.pasteleriacacu.models;

import javax.persistence.*;

@Entity
@Table(name = "ingrediente")
public class IngredienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nombre", nullable = false)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ManyToOne
    private IngredienteTipoModel tipo;

    public IngredienteTipoModel getTipo() {
        return tipo;
    }

    public void setTipo(IngredienteTipoModel tipo) {
        this.tipo = tipo;
    }

    public IngredienteModel() {

    }
    public IngredienteModel(Long id, String nombre, IngredienteTipoModel tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }
}