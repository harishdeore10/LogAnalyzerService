package com.credit.suisse.log.analyzer.service;

import com.credit.suisse.log.analyzer.model.Event;
import com.credit.suisse.log.analyzer.repository.EventRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/*
 * This is a service for database activities using Hibernate ORM.
 * Author: Harish Deore
 *
 */

public class DBService {
    private static Logger LOGGER = LoggerFactory.getLogger(DBService.class);

    public void saveEvents(List<Event> events) {
        LOGGER.info("Saving Events");
        EventRepo eventRepo = new EventRepo();
        eventRepo.saveEvents(events);
        LOGGER.info("Events saved");
    }
}
