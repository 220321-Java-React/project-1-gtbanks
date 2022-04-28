package Models;

//LoginDTO Data Transfer Object. DTO is a model of some data coming in from the front end
//HTTP handler will take in a JSON object sent in by the user, containing their username and pass
//This gets sent to controller to get turned into a Java object using GSON
//The username and pass the user sent in will be put into this DTO as variables, which we'll check in the AuthService
//never store a DTO in the db purely for DAT TRANSFER...we're transferring the username/password

public class LoginDTO {

    private String username;
    private String password;


}
