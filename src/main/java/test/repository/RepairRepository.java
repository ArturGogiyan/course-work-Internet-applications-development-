package test.repository;

import test.entities.RepairsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RepairRepository extends CrudRepository<RepairsEntity, Integer> {
    List<RepairsEntity> findAllByTechworkId(int id);
    List<RepairsEntity> findAllByExemplarId(int id);
}
