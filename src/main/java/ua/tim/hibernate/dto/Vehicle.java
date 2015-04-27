package ua.tim.hibernate.dto;

import javax.persistence.*;

/**
 * Created by timofiybilyi on 4/27/15.
 */

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;
    @ManyToOne
    @JoinColumn (name = "USER_ID")
    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
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
