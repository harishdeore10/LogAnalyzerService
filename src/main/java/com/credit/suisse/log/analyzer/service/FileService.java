package com.credit.suisse.log.analyzer.service;

import com.credit.suisse.log.analyzer.exception.FileProcessingException;
import com.credit.suisse.log.analyzer.mapper.LogMapper;
import com.credit.suisse.log.analyzer.model.Log;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 * This is a service for processing logs files. It is capable of processing large size files as well.
 * Author: Harish Deore
 */

public class FileService {
    private static Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    public List<Log> readFile(File pathToFile) throws FileProcessingException {
        LOGGER.info("Reading file");
        LogMapper logMapper = new LogMapper();
        List<Log> logs = new ArrayList<>();
        LineIterator lineIterator = null;
        try {
            lineIterator = FileUtils.lineIterator(pathToFile, "UTF-8");
            while (lineIterator.hasNext()) {
                String line = lineIterator.nextLine();
                Log log = logMapper.map(line);
                logs.add(log);
            }
            LOGGER.info("File reading complete");
        } catch (Exception exception) {
            LOGGER.error("Exception while reading file " + exception.getMessage());
            throw new FileProcessingException(exception.getMessage());
        } finally {
            LineIterator.closeQuietly(lineIterator);
        }
        return logs;
    }
}
