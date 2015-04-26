package ua.tim.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.tim.hibernate.dto.Address;
import ua.tim.hibernate.dto.UserDetails;

import java.util.Date;

/**
 * Created by timofiybilyi on 4/26/15.
 */
public class HibernateTest {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserName("First User");
        user.setJoinedDate(new Date());
        user.setDescription("First User description");


        Address address = new Address();
        address.setCity("home address city");
        address.setState("home address state");
        user.setHomeAddress(address);

        Address officeAddress = new Address();
        officeAddress.setCity("office address city");
        officeAddress.setState("office address state");
        user.setOfficeAddress(officeAddress);

        user.getListOfAddresses().add(address);
        user.getListOfAddresses().add(officeAddress);
        //read configuration file
        try{
            SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
            session.close();

            user = null;
            session = sessionFactory.openSession();
            user = (UserDetails)session.get(UserDetails.class, 1);
            session.close();
            System.out.println(user.getListOfAddresses().size());
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }
}
