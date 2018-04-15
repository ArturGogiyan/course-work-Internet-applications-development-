package test.repository;

import test.entities.FlightsEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;


public interface FlightRepository extends CrudRepository<FlightsEntity, Integer> {
    List<FlightsEntity> findAllByDateOfFlight(Date date);
    List<FlightsEntity> findAllByShipId(int id);
    List<FlightsEntity> findAllByClientId(int id);
}
