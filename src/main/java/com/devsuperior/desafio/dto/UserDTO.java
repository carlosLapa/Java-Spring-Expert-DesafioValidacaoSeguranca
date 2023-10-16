package com.devsuperior.desafio.dto;

import com.devsuperior.desafio.entities.User;
import jakarta.validation.constraints.Email;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    Set<RoleDTO> roles = new HashSet<>();
    private Long id;
    @Email(message = "Favor entrar um email válido")
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        email = entity.getEmail();
        password = entity.getPassword();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

}
