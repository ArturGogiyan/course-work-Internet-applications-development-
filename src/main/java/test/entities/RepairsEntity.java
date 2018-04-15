package test.entities;

import javax.persistence.*;

@Entity
public class RepairsEntity {
    private int id;
    private int techworkId;
    private int masterId;
    private int exemplarId;
    private Integer repairCost;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTechworkId() {
        return techworkId;
    }

    public void setTechworkId(int techworkId) {
        this.techworkId = techworkId;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public int getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(int exemplarId) {
        this.exemplarId = exemplarId;
    }

    public Integer getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(Integer repairCost) {
        this.repairCost = repairCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepairsEntity that = (RepairsEntity) o;

        if (id != that.id) return false;
        if (techworkId != that.techworkId) return false;
        if (masterId != that.masterId) return false;
        if (exemplarId != that.exemplarId) return false;
        if (repairCost != null ? !repairCost.equals(that.repairCost) : that.repairCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + techworkId;
        result = 31 * result + masterId;
        result = 31 * result + exemplarId;
        result = 31 * result + (repairCost != null ? repairCost.hashCode() : 0);
        return result;
    }
}
