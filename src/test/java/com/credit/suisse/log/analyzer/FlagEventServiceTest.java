package com.credit.suisse.log.analyzer;

import com.credit.suisse.log.analyzer.exception.EventProcessorException;
import com.credit.suisse.log.analyzer.exception.FileProcessingException;
import com.credit.suisse.log.analyzer.model.Event;
import com.credit.suisse.log.analyzer.model.Log;
import com.credit.suisse.log.analyzer.service.FileService;
import com.credit.suisse.log.analyzer.service.FlagEventService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.List;

/*
 * Class to test Flag event Service
 * Author ; Harish Deore
 */

public class FlagEventServiceTest {
    private List<Log> logs;

    @Before
    public void loadFileData() throws FileProcessingException {
        String pathToFile = "src/test/resources/logfile.txt";
        FileService fileService = new FileService();
        File file = new File(pathToFile);
        logs = fileService.readFile(file);
    }

    @Test
    public void testEvents() throws EventProcessorException {
        FlagEventService flagEventService = new FlagEventService();
        List<Event> events = flagEventService.flagEvents(logs);
        Assert.assertNotNull(logs);
        Assert.assertNotNull(events);
    }

    @Test
    public void testNumberOfEventsGenerated() throws EventProcessorException {
        FlagEventService flagEventService = new FlagEventService();
        List<Event> events = flagEventService.flagEvents(logs);
        Assert.assertNotNull(logs);
        Assert.assertNotNull(events);
        Assert.assertEquals(6, logs.size());
        Assert.assertEquals(3, events.size());
    }

    @Test(expected = EventProcessorException.class)
    public void testFileException() throws EventProcessorException {
        FlagEventService flagEventService = new FlagEventService();
        List<Event> events = flagEventService.flagEvents(null);
    }
}
