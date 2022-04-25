package dev.mariocares.pasteleriacacu.repositories;

import dev.mariocares.pasteleriacacu.models.IngredienteTipoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteTipoRepository extends CrudRepository<IngredienteTipoModel, Long> {

}
