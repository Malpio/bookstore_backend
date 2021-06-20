package com.project.bookstore.payload.request;

import java.io.Serializable;

public class LoginRequest implements Serializable {
    private String Username;
    private String Password;

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
}
