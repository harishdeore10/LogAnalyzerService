package com.credit.suisse.log.analyzer.service;

import com.credit.suisse.log.analyzer.exception.EventProcessorException;
import com.credit.suisse.log.analyzer.model.Event;
import com.credit.suisse.log.analyzer.model.Log;
import com.credit.suisse.log.analyzer.model.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*
 * This is a service for events processing. It will calculate time difference and accordingly will generate alert for more than 4ms .
 * Author: Harish Deore
 */

public class FlagEventService {

    private static Logger LOGGER = LoggerFactory.getLogger(FlagEventService.class);


    List<Event> events = new ArrayList<>();

    public List<Event> flagEvents(List<Log> logs) throws EventProcessorException {
        LOGGER.info("Inside Flag Events service");
        try {
            Map<String, List<Log>> logsMap = logs.stream().collect(Collectors.groupingBy(Log::getId));

            for (Map.Entry<String, List<Log>> entry : logsMap.entrySet()) {
                List<Log> logList = entry.getValue();
                Long startTime = 0L;
                Long endTime = 0L;
                Long diff = 0L;
                for (Log log : logList) {
                    if (State.STARTED.equals(log.getState())) {
                        startTime = Long.parseLong(log.getTimestamp());
                    }
                    if (State.FINISHED.equals(log.getState())) {
                        endTime = Long.parseLong(log.getTimestamp());
                    }
                }
                diff = endTime - startTime;
                createEvent(logList.get(0), diff);
            }
        } catch (Exception exception) {
            LOGGER.error("Error while processing events " + exception.getMessage());
            throw new EventProcessorException(exception.getMessage());
        }

        return events;
    }


    private void createEvent(Log log, Long duration) {
        LOGGER.info("Creating events");
        Event event = new Event();
        event.setId(log.getId());
        event.setDuration(duration);
        event.setHost(log.getHost());
        event.setType(log.getType());

        if (duration >= 4)
            event.setAlert(Boolean.TRUE);
        else
            event.setAlert(Boolean.FALSE);

        events.add(event);
    }
}
