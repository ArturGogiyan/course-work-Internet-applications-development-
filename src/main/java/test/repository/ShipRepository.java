package test.repository;

import test.entities.ShipsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ShipRepository extends CrudRepository<ShipsEntity,Integer> {
    List<ShipsEntity> findAllByAtmosphereType(String type);
}
