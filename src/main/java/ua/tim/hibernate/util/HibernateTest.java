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

            //demo session cache
            //first select write to session cache
            UserDetails user1 = (UserDetails)session.get(UserDetails.class, 1);

            //second select use session cache get from cache
            UserDetails user2 = (UserDetails)session.get(UserDetails.class, 1);

            session.getTransaction().commit();
            session.close();


            //another session
            session = sessionFactory.openSession();
            session.beginTransaction();

            //get first select writhe to session cache
            UserDetails user3 = (UserDetails)session.get(UserDetails.class, 1);

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
