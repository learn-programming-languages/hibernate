package ua.tim.hibernate.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by timofiybilyi on 4/27/15.
 */
@Entity
@DiscriminatorValue(value = "bike")
public class TwoWheeler extends Vehicle{

    private String steerHandle;

    public String getSteerHandle() {
        return steerHandle;
    }

    public void setSteerHandle(String steerHandle) {
        this.steerHandle = steerHandle;
    }
}
