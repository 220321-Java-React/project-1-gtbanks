package com.revature.backend.domain.model;

//LoginDTO Data Transfer Object. DTO is a model of some data coming in from the front end
//HTTP handler will take in a JSON object sent in by the user, containing their username and pass
//This gets sent to controller to get turned into a Java object using GSON
//The username and pass the user sent in will be put into this DTO as variables, which we'll check in the AuthService
//never store a DTO in the db purely for DAT TRANSFER...we're transferring the username/password

public class User {
//identify variables
    private int user_id;
    private String username;
    private String password;
    private String f_name;
    private String l_name;
    private String email;
    private int user_role_id_fk;
//create a no args and all args constructors, allows us to instatiate UserLoginDTOs


    public User() {
        super();
    }

    //constructors

    public User(int user_id, String username, String password, String f_name,
                String l_name, String email, int user_role_id_fk) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.user_role_id_fk = user_role_id_fk;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", email='" + email + '\'' +
                ", user_role_id_fk=" + user_role_id_fk +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_role_id_fk() {
        return user_role_id_fk;
    }

    public void setUser_role_id_fk(int user_role_id_fk) {
        this.user_role_id_fk = user_role_id_fk;
    }

}
