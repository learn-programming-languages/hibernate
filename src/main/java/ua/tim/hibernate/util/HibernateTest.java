package ua.tim.hibernate.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.tim.hibernate.dto.UserDetails;

import java.util.List;

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
            Query query = session.createQuery("from UserDetails where userId = 1");
            query.setCacheable(true);
            List<UserDetails> userList = query.list();

            session.getTransaction().commit();
            session.close();


            //two session
            Session session2 = sessionFactory.openSession();
            session2.beginTransaction();

            Query query2 = session2.createQuery("from UserDetails where userId = 1");
            query2.setCacheable(true);
            List<UserDetails> userList2 = query2.list();


            session2.getTransaction().commit();
            session2.close();


        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }
}
