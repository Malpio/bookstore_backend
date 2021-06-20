package com.project.bookstore.payload.request;

import java.io.Serializable;
import java.util.Set;

public class SignupRequest implements Serializable {
    private String username;
    private String email;
    private String password;
    private Set<String> roles;

    public SignupRequest(String username, String email, String password, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
