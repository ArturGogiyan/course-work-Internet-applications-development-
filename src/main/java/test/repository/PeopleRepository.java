package test.repository;
import test.entities.PeopleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<PeopleEntity, Integer> {
    List<PeopleEntity> findByNameAndSurname(String name, String surname);
    Iterable<PeopleEntity> findAll();
    PeopleEntity findByUserName(String userName);
    PeopleEntity findByName(String Name);
    PeopleEntity findById(int id);
}