package ua.tim.hibernate.util;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
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

            for (int i = 0; i < 10; i++){
                UserDetails user = new UserDetails();
                user.setUserName("user details name: " + i);
                session.save(user);
            }

            session.getTransaction().commit();
            session.close();



            session = sessionFactory.openSession();
            session.beginTransaction();

            //Criteria
            Criteria criteria = session.createCriteria(UserDetails.class)
                    .addOrder(Order.desc("userId"));


            List<UserDetails> listOfRowFromUserDetails = criteria.list();


            session.getTransaction().commit();
            session.close();
            for (UserDetails user: listOfRowFromUserDetails){
                System.out.println(user.getUserName());
            }

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }
}
