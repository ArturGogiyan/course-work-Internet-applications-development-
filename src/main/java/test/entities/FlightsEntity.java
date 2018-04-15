package test.entities;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class FlightsEntity {
    private int id;
    private String startPlanetName;
    private String finishPlanetName;
    private Date dateOfFlight;
    private String cargoType;
    private int weight;
    private int shipId;
    private int clientId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartPlanetName() {
        return startPlanetName;
    }

    public void setStartPlanetName(String  startPlanetId) {
        this.startPlanetName = startPlanetId;
    }

    public String  getFinishPlanetName() {
        return finishPlanetName;
    }

    public void setFinishPlanetName(String  finishPlanetId) {
        this.finishPlanetName = finishPlanetId;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public int getWeight() {
        return weight;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightsEntity that = (FlightsEntity) o;

        if (id != that.id) return false;
        if (!(startPlanetName.equals(that.startPlanetName))) return false;
        if (!(finishPlanetName.equals(that.finishPlanetName))) return false;
        if (shipId != that.shipId) return false;
        if (dateOfFlight != null ? !dateOfFlight.equals(that.dateOfFlight) : that.dateOfFlight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + startPlanetName.hashCode();
        result = 31 * result + finishPlanetName.hashCode();
        result = 31 * result + (dateOfFlight != null ? dateOfFlight.hashCode() : 0);
        result = 31 * result + shipId;
        return result;
    }
}
