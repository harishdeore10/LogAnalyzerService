package com.credit.suisse.log.analyzer.mapper;

import com.credit.suisse.log.analyzer.model.Log;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


/*
* This class will convert String to JSON object
* Author: Harish Deore
**/

public class LogMapper {

    public Log map(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Log log = objectMapper.readValue(jsonString, Log.class);
        return log;
    }
}
