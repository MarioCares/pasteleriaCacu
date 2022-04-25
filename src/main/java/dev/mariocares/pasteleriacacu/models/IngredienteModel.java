package dev.mariocares.pasteleriacacu.models;

import javax.persistence.*;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    private IngredienteTipoModel tipo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}