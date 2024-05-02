package com.jimmysalazar.lombokexample.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigService {

    @Getter(lazy = true) // Sirve para mejorar el performance, sólo se llama cuando se necesite
    private final String configuration = getConfigurationFromRemoteSource();

    public String getConfigurationFromRemoteSource() {
      log.info("Getting configuration");
      try {
          Thread.sleep(2000);
      }catch (InterruptedException e){
      }
      log.info("Configuration generated");
      return "Configuration from remote source";
    }
}
