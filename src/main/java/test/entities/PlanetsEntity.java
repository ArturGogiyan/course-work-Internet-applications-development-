package test.entities;

import javax.persistence.*;

@Entity
public class PlanetsEntity {
    private int id;
    private String atmosphereType;
    private int coordX;
    private int coordY;
    private int coordZ;
    private String name;
    private String imageURL;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtmosphereType() {
        return atmosphereType;
    }

    public void setAtmosphereType(String atmosphereId) {
        this.atmosphereType = atmosphereId;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public int getCoordZ() {
        return coordZ;
    }

    public void setCoordZ(int coordZ) {
        this.coordZ = coordZ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanetsEntity that = (PlanetsEntity) o;

        if (id != that.id) return false;
        if (atmosphereType != that.atmosphereType) return false;
        if (coordX != that.coordX) return false;
        if (coordY != that.coordY) return false;
        if (coordZ != that.coordZ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + atmosphereType.hashCode();
        result = 31 * result + coordX;
        result = 31 * result + coordY;
        result = 31 * result + coordZ;
        return result;
    }
}
