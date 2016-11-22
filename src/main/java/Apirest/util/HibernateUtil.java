package Apirest.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration

/**
 * Created by lcc on 22/11/2016.
 */
public class HibernateUtil {
    private static  final SessionFactory sessionFactory = buildSessionFactory();

    @Bean
    private  static SessionFactory buildSessionFactory() {
        try {

            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static  SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static  void shutdown() {
        getSessionFactory().close();
    }
}
