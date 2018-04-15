package test.entities;

import javax.persistence.*;


@Entity
public class ShipsEntity {
    private int id;
    private String atmosphereType;
    private String color;

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

    public void setAtmosphereType(String  atmosphereType) {
        this.atmosphereType = atmosphereType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShipsEntity that = (ShipsEntity) o;

        if (id != that.id) return false;
        if (!atmosphereType.equals(that.atmosphereType)) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + atmosphereType.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
