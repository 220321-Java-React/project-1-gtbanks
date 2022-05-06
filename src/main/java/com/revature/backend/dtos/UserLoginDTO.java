package com.revature.backend.dtos;

//DTO Data Transfer Object
public class UserLoginDTO {

    private String username;
    private String password;

    public UserLoginDTO(String username, String password) {

        this.username = username;
        this.password = password;

    }
//so we can print out this out for debug
    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public UserLoginDTO() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
