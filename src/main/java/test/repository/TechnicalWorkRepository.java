package test.repository;

import test.entities.TechnicalWorkEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TechnicalWorkRepository extends CrudRepository<TechnicalWorkEntity, Integer> {
    List<TechnicalWorkEntity> findAllByShipId(int id);
    List<TechnicalWorkEntity> findAllByServiceId(int id);
}
