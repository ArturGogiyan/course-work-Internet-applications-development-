package test.repository;

import test.entities.ChangesEntity;
import org.springframework.data.repository.CrudRepository;
import test.entities.ShipsEntity;

import java.util.List;

public interface ChangesRepository extends CrudRepository<ChangesEntity, Integer> {
    List<ChangesEntity> getAllByShipId(int id);
}
