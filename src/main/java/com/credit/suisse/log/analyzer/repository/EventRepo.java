package com.credit.suisse.log.analyzer.repository;

import com.credit.suisse.log.analyzer.exception.DBException;
import com.credit.suisse.log.analyzer.model.Event;
import com.credit.suisse.log.analyzer.service.DBService;
import com.credit.suisse.log.analyzer.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/*
 * This is a repo to store event data to database.
 * Author: Harish Deore
 */

public class EventRepo {

    private static Logger LOGGER = LoggerFactory.getLogger(DBService.class);

    Transaction tx = null;
    Session session = null;

    public void saveEvents(List<Event> events) {
        LOGGER.info("Saving events to database");
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            for (Event event : events) {
                addEvent(event);
            }
        } catch (Throwable ex) {
            LOGGER.error("Error while saving events to DB " + ex.getMessage());
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        } finally {
            HibernateUtil.shutdown();
        }
    }

    /* Method to CREATE an employee in the database */
    public void addEvent(Event event) throws DBException {
        try {
            tx = session.beginTransaction();
            session.save(event);
            tx.commit();
        } catch (HibernateException exception) {
            if (tx != null)
                tx.rollback();
            throw new DBException(exception.getMessage());
        }
    }
}
