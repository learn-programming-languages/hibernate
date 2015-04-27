package ua.tim.hibernate.dto;

import javax.persistence.*;


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

    @OneToOne
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;

    public int getUserId() {
        return userId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
