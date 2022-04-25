package dev.mariocares.pasteleriacacu.repositories;

import dev.mariocares.pasteleriacacu.models.IngredienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends CrudRepository<IngredienteModel, Long> {
}
