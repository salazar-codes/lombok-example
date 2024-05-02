package com.jimmysalazar.lombokexample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@ToString
@ToString(onlyExplicitlyIncluded = true) // Llama a los incluidos explícitamente
public class User {
    @Getter
    @Setter
    @ToString.Include // Incluye de forma explícita
    private Integer id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    @ToString.Exclude  // Excluye el parámetro de forma explícita
    private String password;
    @Getter
    @Setter
    private String role;

    /*
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
     */
}
