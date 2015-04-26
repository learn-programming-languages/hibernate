package ua.tim.hibernate.dto;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by timofiybilyi on 4/25/15.
 */
@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {
    @Id
    private int userId;

    private String userName;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    private String description;

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
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