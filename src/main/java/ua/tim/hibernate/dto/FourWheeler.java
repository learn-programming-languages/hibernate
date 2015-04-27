package ua.tim.hibernate.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by timofiybilyi on 4/27/15.
 */
@Entity
@DiscriminatorValue(value = "car")
public class FourWheeler extends Vehicle{
    private String steeringWhill;

    public String getSteeringWhill() {
        return steeringWhill;
    }

    public void setSteeringWhill(String steeringWhill) {
        this.steeringWhill = steeringWhill;
    }
}
