package com.virusoft.draculahrm.app;

import com.virusoft.draculahrm.model.base.Department;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class AppConfig {
    private static final Properties properties = new Properties();

    static {
        // Database Configuration
        properties.setProperty("hibernate.connection.url", "jdbc:sqlite:hrm_local.db");
        properties.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        // Security Configuration
        properties.setProperty("maxLoginAttempts", "3");
        properties.setProperty("sessionTimeoutMinutes", "15");

        // Email Configuration
        properties.setProperty("smtp.host", "smtp.gmail.com");
        properties.setProperty("smtp.port", "587");
        properties.setProperty("smtp.username", "yourcompanyemail@gmail.com");
        properties.setProperty("smtp.password", "yourpassword");
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // ✅ Method to create and return Hibernate SessionFactory
    private static final SessionFactory sessionFactory = new Configuration()
            .addProperties(properties)
            .addAnnotatedClass(Department.class) // Register entity
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
