package ua.tim.hibernate.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by timofiybilyi on 4/25/15.
 */
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;

    @ManyToMany
    private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

    public int getUserId() {
        return userId;
    }

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicles) {
        this.vehicle = vehicles;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
