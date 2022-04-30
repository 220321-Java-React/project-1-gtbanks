package com.revature.backend.dtos;

//DTO Data Transfer Object
public class UserLoginDTO {

    private String username;
    private String password;
    private int userRole;

    public UserLoginDTO(String username, String password, int userRole) {

        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
//so we can print out this out for debug
    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_role_id_fk" +'\'' +
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

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
