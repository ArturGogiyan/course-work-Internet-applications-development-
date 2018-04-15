package test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by edvanchi on 05.01.2018.
 */
@Entity
public class RolesEntity {
    private int id;
    private String roleName;
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String role_id) {
        this.userName = role_id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
