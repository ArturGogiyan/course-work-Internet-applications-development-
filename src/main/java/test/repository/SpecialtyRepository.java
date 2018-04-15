package test.repository;

import test.entities.SpecialtiesEntity;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<SpecialtiesEntity,Integer>{
}
