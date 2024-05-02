package com.jimmysalazar.lombokexample.service.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrintService {

    public void printMessage(String message) {
        log.info(message);
    }
}
