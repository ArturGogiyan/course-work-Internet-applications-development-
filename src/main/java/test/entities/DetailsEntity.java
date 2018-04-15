package test.entities;

import javax.persistence.*;


@Entity
public class DetailsEntity {
    private int id;
    private int typeDetailId;
    private int atmosphereId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeDetailId() {
        return typeDetailId;
    }

    public void setTypeDetailId(int typeDetailId) {
        this.typeDetailId = typeDetailId;
    }

    public int getAtmosphereId() {
        return atmosphereId;
    }

    public void setAtmosphereId(int atmosphereId) {
        this.atmosphereId = atmosphereId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailsEntity that = (DetailsEntity) o;

        if (id != that.id) return false;
        if (typeDetailId != that.typeDetailId) return false;
        if (atmosphereId != that.atmosphereId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + typeDetailId;
        result = 31 * result + atmosphereId;
        return result;
    }
}
