package test.repository;

import test.entities.PlanetsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PlanetRepository extends CrudRepository<PlanetsEntity, Integer> {
    List<PlanetsEntity> findAllByAtmosphereType(String Type);
    PlanetsEntity findByName(String name);
}
