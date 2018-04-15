package test.repository;

import test.entities.ServicesEntity;
import org.springframework.data.repository.CrudRepository;

import javax.xml.ws.Service;


public interface ServiceRepository extends CrudRepository<ServicesEntity, Integer> {
}
