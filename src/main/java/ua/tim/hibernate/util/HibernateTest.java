package ua.tim.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.tim.hibernate.dto.UserDetails;

import java.util.Date;

/**
 * Created by timofiybilyi on 4/26/15.
 */
public class HibernateTest {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserId(1);
        user.setUserName("First User");
        user.setJoinedDate(new Date());
        user.setDescription("First User description");
        //read configuration file
        try{
            SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }
}
