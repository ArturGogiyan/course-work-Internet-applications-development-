package test.repository;

import test.entities.JournalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface JournalRepository extends CrudRepository<JournalEntity, Integer>{
    List<JournalEntity> findAllByShipId(int id);
}