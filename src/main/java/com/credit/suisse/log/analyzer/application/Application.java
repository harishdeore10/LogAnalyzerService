package com.credit.suisse.log.analyzer.application;

import com.credit.suisse.log.analyzer.model.Event;
import com.credit.suisse.log.analyzer.service.DBService;
import com.credit.suisse.log.analyzer.service.FileService;
import com.credit.suisse.log.analyzer.service.FlagEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/*
 * This is application class which initializes log analyzer program. It takes path file path as an
 * command line argument then reads that file. After reading it processes the logs file and store it into
 * HSQLDB as events. It is capable of processing large files as well.
 *
 * Author :  Harish Deore
 *
 */

public class Application {

    private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        FileService fileService = new FileService();
        FlagEventService flagEventService = new FlagEventService();
        DBService dbService = new DBService();
        LOGGER.info("Command line arguments received : " + args[0]);

        File file = new File(args[0]);
        try {
            List<Event> events = flagEventService.flagEvents(fileService.readFile(file));
            LOGGER.info("Events received : " + events);
            dbService.saveEvents(events);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
    }
}
