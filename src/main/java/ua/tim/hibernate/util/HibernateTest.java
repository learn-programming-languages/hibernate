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
//            for (int i = 0 ;i < 10; i++) {
//                UserDetails userDetails = new UserDetails();
//                userDetails.setUserName("User #" + i);
//                session.save(userDetails);
//            }
            UserDetails userDetails = (UserDetails)session.get(UserDetails.class, 1);
//            System.out.println(userDetails.getUserName());
            userDetails.setUserName("UPDATE");
            session.update(userDetails);

            session.delete(userDetails);
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
