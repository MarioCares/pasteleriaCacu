package dev.mariocares.pasteleriacacu.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ingrediente_tipo")
public class IngredienteTipoModel implements Serializable {
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

    @Column
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_id")
    private Set<IngredienteModel> ingredientes;

    public Set<IngredienteModel> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<IngredienteModel> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public IngredienteTipoModel(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public IngredienteTipoModel() {
    }
}