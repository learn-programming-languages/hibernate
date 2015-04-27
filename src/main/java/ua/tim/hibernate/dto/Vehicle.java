package ua.tim.hibernate.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by timofiybilyi on 4/27/15.
 */

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;

    @ManyToMany (mappedBy = "vehicle")
    private Collection<UserDetails> userDetails = new ArrayList<UserDetails>();

    public Collection<UserDetails> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Collection<UserDetails> userDetails) {
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
