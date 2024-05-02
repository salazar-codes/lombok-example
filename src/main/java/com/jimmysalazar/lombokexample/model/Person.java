package com.jimmysalazar.lombokexample.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String lastname;
    @Getter
    @Setter
    private boolean alive;

    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String alias;

    private static final Logger log = LoggerFactory.getLogger(Person.class);

    public void foo(){
        setAlias("eldev");
        String alias = getAlias();
        log.info("Alias {}",alias);
    }

    /*
    // getters and setters - old way

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
     */
}
