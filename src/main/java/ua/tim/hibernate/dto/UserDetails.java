package ua.tim.hibernate.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
        @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
        @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
        @AttributeOverride(name = "pincode", column = @Column(name = "HOME_PIN_CODE"))
    })
    private Address homeAddress;

    @Embedded
    private Address officeAddress;

    @ElementCollection
    @JoinTable(name = "USER_ADDRESS",
            joinColumns=@JoinColumn(name="USER_ID"))
    private Set<Address> listOfAddresses = new HashSet<Address>();

    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    //@Lob
    private String description;

    public Set<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Set<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }
}
