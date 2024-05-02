package com.jimmysalazar.lombokexample.service.spring;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class HelloService {
    //@Autowired
    //private PrintService service;
    private final PrintService service;

    private String prefix = "HELLO MESSAGE";
    public void sayHello() {
        service.printMessage(String.format("%s - %s", prefix, "Hello from service"));
    }
}
