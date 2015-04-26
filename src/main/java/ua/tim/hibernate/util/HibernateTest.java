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
        address.setCity("address city");
        address.setState("address state");
        user.setHomeAddress(address);

        //read configuration file
        try{
            SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
            session.close();

//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            user = (UserDetails)session.get(UserDetails.class, 1);
//            System.out.println("user name retriving as: " + user.getUserName());
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }
}
