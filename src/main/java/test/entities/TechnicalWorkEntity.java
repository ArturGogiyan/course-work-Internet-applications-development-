package test.entities;

import javax.persistence.*;


@Entity
public class TechnicalWorkEntity {
    private int id;
    private int serviceId;
    private int shipId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TechnicalWorkEntity that = (TechnicalWorkEntity) o;

        if (id != that.id) return false;
        if (serviceId != that.serviceId) return false;
        if (shipId != that.shipId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + serviceId;
        result = 31 * result + shipId;
        return result;
    }
}
