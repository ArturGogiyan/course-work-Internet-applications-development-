package test.repository;

import test.entities.DetailsEntity;
import org.springframework.data.repository.CrudRepository;

import javax.xml.soap.DetailEntry;
import java.util.List;


public interface DetailRepository extends CrudRepository<DetailsEntity, Integer> {
    List<DetailsEntity> getAllByAtmosphereId(int id);
    List<DetailsEntity> getAllByTypeDetailId(int id);
}
