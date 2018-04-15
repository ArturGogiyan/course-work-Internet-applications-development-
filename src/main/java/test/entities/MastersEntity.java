package test.entities;

import javax.persistence.*;


@Entity
public class MastersEntity {
    private int id;
    private int peopleId;
    private int specialtiesId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public int getSpecialtiesId() {
        return specialtiesId;
    }

    public void setSpecialtiesId(int specialtiesId) {
        this.specialtiesId = specialtiesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MastersEntity that = (MastersEntity) o;

        if (id != that.id) return false;
        if (peopleId != that.peopleId) return false;
        if (specialtiesId != that.specialtiesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + peopleId;
        result = 31 * result + specialtiesId;
        return result;
    }
}
