package ua.tim.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.tim.hibernate.dto.UserDetails;
import ua.tim.hibernate.dto.Vehicle;

/**
 * Created by timofiybilyi on 4/26/15.
 */
public class HibernateTest {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserName("First User");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("car1");
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("car2");

        user.getVehicle().add(vehicle1);
        user.getVehicle().add(vehicle2);
        vehicle1.getUserDetails().add(user);
        vehicle2.getUserDetails().add(user);

        //read configuration file
        try{
            SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(user);
            session.save(vehicle1);
            session.save(vehicle2);
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
