package ua.tim.hibernate.dto;

import javax.persistence.*;

/**
 * Created by timofiybilyi on 4/27/15.
 */

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class Vehicle {
    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;


    @ManyToOne
    private UserDetails user;

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
