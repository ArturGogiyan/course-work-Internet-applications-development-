package test.repository;

import test.entities.ProvidersEntity;
import org.springframework.data.repository.CrudRepository;


public interface ProviderRepository extends CrudRepository<ProvidersEntity,Integer> {
}
