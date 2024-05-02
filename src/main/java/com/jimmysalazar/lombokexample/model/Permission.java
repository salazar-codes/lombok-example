package com.jimmysalazar.lombokexample.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Permission {
    private Integer id;
    private String name;
    private LocalDateTime createTs;
}
