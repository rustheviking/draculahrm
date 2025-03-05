package com.virusoft.draculahrm.utils.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.virusoft.draculahrm.app.AppConfig;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            // Set Hibernate properties from AppConfig
            configuration.setProperty("hibernate.connection.url", AppConfig.getProperty("hibernate.connection.url"));
            configuration.setProperty("hibernate.connection.driver_class", AppConfig.getProperty("hibernate.connection.driver_class"));
            configuration.setProperty("hibernate.dialect", AppConfig.getProperty("hibernate.dialect"));
            configuration.setProperty("hibernate.hbm2ddl.auto", AppConfig.getProperty("hibernate.hbm2ddl.auto"));

            // Add annotated entity classes (modify according to your entities)
            configuration.addAnnotatedClass(com.virusoft.draculahrm.model.employee.Employee.class);
            configuration.addAnnotatedClass(com.virusoft.draculahrm.model.employee.Position.class);

            // Build ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("Hibernate SessionFactory closed.");
        }
    }
}

