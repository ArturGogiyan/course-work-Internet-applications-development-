package test.repository;

import test.entities.ExemplarsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ExemplarRepository extends CrudRepository<ExemplarsEntity,Integer> {
    List<ExemplarsEntity> getByDetailId(int id);
}
