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
