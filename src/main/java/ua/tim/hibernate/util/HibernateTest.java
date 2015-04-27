package ua.tim.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.tim.hibernate.dto.FourWheeler;
import ua.tim.hibernate.dto.TwoWheeler;
import ua.tim.hibernate.dto.Vehicle;

/**
 * Created by timofiybilyi on 4/26/15.
 */
public class HibernateTest {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("vehicle");

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("HONDA VTR 250");
        bike.setSteerHandle("street handle");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Nissan z30");
        car.setSteeringWhill("streeting wheel");


        //read configuration file
        try{
            SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(vehicle);
            session.save(car);
            session.save(bike);

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
