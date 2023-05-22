package org.example.api;


public class LoginUserPojo {
    private String email;
    private String password;

    public LoginUserPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

