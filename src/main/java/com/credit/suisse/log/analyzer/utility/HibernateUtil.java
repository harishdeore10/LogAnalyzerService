package com.credit.suisse.log.analyzer.utility;

import com.credit.suisse.log.analyzer.service.FlagEventService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * This is a utility class for Hibernate Session factory.
 * Author: Harish Deore
 */


public class HibernateUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(FlagEventService.class);

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        LOGGER.info("Inside Hibernate utilities building Session Factory");
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
                StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
                serviceRegistryBuilder.applySettings(configuration.getProperties());
                ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            LOGGER.info("Building Session Factory complete");
            return sessionFactory;
        } catch (Throwable ex) {
            LOGGER.error("Error while building Session Factory.");
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}