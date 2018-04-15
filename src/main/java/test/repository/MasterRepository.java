package test.repository;

import test.entities.MastersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MasterRepository extends CrudRepository<MastersEntity, Integer> {
    MastersEntity findByPeopleId(int id);
    List<MastersEntity> findAllBySpecialtiesId(int id);

}
