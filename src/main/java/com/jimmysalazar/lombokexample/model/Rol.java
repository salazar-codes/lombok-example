package com.jimmysalazar.lombokexample.model;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class Rol {
    @NonNull
    @ToString.Exclude // Puedo combinarlas con Data
    private Integer id;
    private String name;
    private LocalDateTime lastUpdateTs;
    private LocalDateTime createTs;
}
