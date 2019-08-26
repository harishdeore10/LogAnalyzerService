package com.credit.suisse.log.analyzer;

import com.credit.suisse.log.analyzer.exception.FileProcessingException;
import com.credit.suisse.log.analyzer.model.Log;
import com.credit.suisse.log.analyzer.service.FileService;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

/*
 * Class to test File Service.
 * Author ; Harish Deore
 */

public class FileServiceTest {

    @Test
    public void testFile() throws FileProcessingException {
        String pathToFile = "src/test/resources/logfile.txt";
        FileService fileService = new FileService();
        File file = new File(pathToFile);
        List<Log> logs = fileService.readFile(file);
        Assert.assertNotNull(logs);
    }

    @Test
    public void testNumberOfRecordsLoadedFile() throws FileProcessingException {
        String pathToFile = "src/test/resources/logfile.txt";
        FileService fileService = new FileService();
        File file = new File(pathToFile);
        List<Log> logs = fileService.readFile(file);
        Assert.assertEquals(6, logs.size());
    }

    @Test(expected = FileProcessingException.class)
    public void testFileException() throws FileProcessingException {
        String pathToFile = "/src/test/resources/logfile.txt";
        FileService fileService = new FileService();
        File file = new File(pathToFile);
        fileService.readFile(file);
    }
}
