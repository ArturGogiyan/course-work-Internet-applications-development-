package test.repository;

import test.entities.DetailTypeEntity;
import org.springframework.data.repository.CrudRepository;


public interface DetailTypeRepository extends CrudRepository<DetailTypeEntity, Integer> {
}
