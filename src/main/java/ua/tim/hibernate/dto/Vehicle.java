package ua.tim.hibernate.dto;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    @NotFound( action = NotFoundAction.IGNORE)
    private UserDetails user;


    //private Collection<UserDetails> userDetails = new ArrayList<UserDetails>();

//    public Collection<UserDetails> getUserDetails() {
//        return userDetails;
//    }
//
//    public void setUserDetails(Collection<UserDetails> userDetails) {
//        this.userDetails = userDetails;
//    }

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
