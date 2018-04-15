package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.entities.AtmosphereEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AtmosphereRepository extends CrudRepository<AtmosphereEntity, Integer> {
    public AtmosphereEntity getAtmosphereEntitiesByType(String type);
}
