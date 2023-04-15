package org.example.api;

public class CreateUserPojo {
    private String email;
    private String password;
    private String name;

    public CreateUserPojo(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public CreateUserPojo() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
