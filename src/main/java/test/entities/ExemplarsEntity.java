package test.entities;

import javax.persistence.*;


@Entity
public class ExemplarsEntity {
    private int id;
    private int cost;
    private int wear;
    private int providerId;
    private int detailId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWear() {
        return wear;
    }

    public void setWear(int wear) {
        this.wear = wear;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExemplarsEntity that = (ExemplarsEntity) o;

        if (id != that.id) return false;
        if (cost != that.cost) return false;
        if (wear != that.wear) return false;
        if (providerId != that.providerId) return false;
        if (detailId != that.detailId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cost;
        result = 31 * result + wear;
        result = 31 * result + providerId;
        result = 31 * result + detailId;
        return result;
    }
}
