package com.jimmysalazar.lombokexample.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

//@ToString
@ToString(onlyExplicitlyIncluded = true) // Llama a los incluidos explícitamente
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Getter
    @Setter
    @ToString.Include // Incluye de forma explícita
    @EqualsAndHashCode.Include
    private Integer id;
    @Getter
    @Setter
    @EqualsAndHashCode.Include
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }

     */
}
