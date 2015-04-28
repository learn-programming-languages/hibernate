package ua.tim.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.tim.hibernate.dto.UserDetails;

/**
 * Created by timofiybilyi on 4/26/15.
 */
public class HibernateTest {
    public static void main(String[] args) {




        //read configuration file
        try{
            SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            UserDetails user = new UserDetails();
            session.save(user);
            UserDetails userDetails = (UserDetails)session.get(UserDetails.class, 1);

            session.getTransaction().commit();
            session.close();

            userDetails.setUserName("DETACHED OBJECT");

            session = sessionFactory.openSession();
            session.beginTransaction();

            session.update(userDetails);

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
