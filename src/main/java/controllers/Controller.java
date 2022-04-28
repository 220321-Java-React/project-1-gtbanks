package controllers;


//The controller layer is where HTTP req get sent after Jaalin directs them
//parses any JSON into Java objects and vice versa
//W'll either getting data from service which gets the data from the DAO
//or sending data that came from the webpage to the service layer which sends the data to DAO

/*
public class Controller {

    //this Handler will get the HTTP GET request for all employees, and send back the employees from the
    //database
    public handler getHandler = (ctx) -> {

        /* we need an ArrayList of Employee objects (which we'll get from service layer
        create a GSON object to convert our Java object into JSON(since we can only transfer JSON, not Java
        then use the JSON .toJson() method to turn Java into JSON
        give a response contianing out JSON string back to the web page
        Give a HTTP response containing our JSON string back to the webpage(or wherever the HTTP request came from)
*?
    }
}
*/