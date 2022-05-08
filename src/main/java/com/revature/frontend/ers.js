const url = "http://localhost:3000";
//put base URL in a variable for cleaner code
//eventually , we'll use this in fetch request and make calls to our server by appending endpoints

//add event listener to give button functionality
//begin login
///
//THIS FUNCTION sends user-input login creds to our server
document.getElementById("loginButton").addEventListener("click", loginFunction);
async function loginFunction(){
    //get user inputs from the login input
    //when login button is clicked, the value from username and password will be put into variables
    console.log("function")
    //let username = document.login("username").value;
    //let password = document.login("password").value;
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    //user/pass we need to convert JSON to JS object before sending further
    let user = {
        username:usern,
        password: userp
    }
    //The object must reflect the LoginDTO in Java...to be transferred
    //Print out user object to the console for any dubugging needs
    console.log(user); 
    //fetch request to server
    //the second parameter in a fetch is to config our fetch request
    //fetch sends a GET by default, but we need a POST, as well as other configs.
    let response = await fetch(url+"/login", {
        method: "POST", //send a POST req (GET is the default verb)
        body: JSON.stringify(user),
        credentials: "include"
        //Last line will ensure the cookie is captured(so we can have a session)
        //future fetches after login will require this "include" value
    })
    //log the response status code, useful for debutgs
    console.log(response.status);
    
    //control flow based on successful/unsuccessful login
    if(response.status === 202) {
        //convert from json to JS
        let data = await response.json();
        //wipe our login row and welcome the user

        //Remember to use direct URL from webpage as shown below:
        if(data.user_role_id_fk ===1) {
             window.location.replace('http://127.0.0.1:5500/src/main/java/com/revature/frontend/WelcomeManagement.html') 
            //window.location.href = 'http://127.0.0.1:5500/src/main/java/com/revature/frontend/WelcomeManagement.html')
        }
        else {
            window.location.href = 'http://127.0.0.1:5500/src/main/java/com/revature/frontend/WelcomeStaff.html';
        }
        document.login("loginRow").innerText="Welcome" +data.first_name + "! !";
        //put your redirect here if multipleHTML pages 
        //window.location.href = 'https://ExampleURL.com/';
        //This adds a new entry to the session history(user can use back button to return)
        //Reference: https://www.semrush.com/blog/javascript-redirect/
    }else {
        document.getElementById("welcomeHead").innerText="Login Failed! Try aagain and Get it Right";
        document.getElementById("welcomeHead").style.color = "red";
    }

//end login
//////////////////////////////////////////////////////////////////////////////////////////

//GET ALL REIMBURSEMENTS
/*document.getElementById("getAll").addEventListener("click", getAll);

//When the loginButton gets clicked, execute the loginFunction
document.getElementById("loginButton").addEventListener("click", getAll);
*/

document.getElementById("getAllButoon").addEventListener("click", getAll);

//getAll is an asynchronous function which has a fetch request to get reimbursements from our server
//remember, asych makes a function return a promise(which fetch requests return) it is left empty
async function getAll() {

//we will send a fetch req to get all reimb data
//by default, fetch requests send GET req and others like POST)
//The url = http://localhost:3000"+ resource named in Launcher and controller handlers
let response = await fetch(url + "/reimbursements", {credentials: "include"}); //afterurl string not in 1st part of video

//log the response in the console just to see the response object(good for debugging)
console.log(response);

//control flow on the status
//now we can access the status code (as well as other stuff) through our response variable
if(response.status === 200) {

    //parse JSON back to JS object
    //.json() method that turns json to JS object
    let data = await response.json();
    //log the actual reimbursement data parsed from JSON
    console.log(data);
    //For every reimb object we get from fetch request, put it in the web table
    for(let reimbursement of data){
        //1.create a table row
        let row = document.createElement("tr");
        //2.create data cell
        let cell = document.createElement("td");
        //3.fill cell with reimb data names must match db
        cell.innerHTML = ers_reimbursement.reimb_id;
        //4.add the td element(data cell) to the tr element (table row)
        //Take this row variable and append a new child to it, which is the td
        row.appendChild(cell);
        
        //5.we do this^^^^for every column in reimb
        let cell2 = document.createElement("td");
        cell.innerHTML = ers_reimbursement.reimb_amount;
        row.appendChild(cell2);

        let cell3 = document.createElement("td");
        cell.innerHTML = ers_reimbursement.reimb_submitted;
        row.appendChild(cell3);

        let cell4 = document.createElement("td");
        cell.innerHTML = ers_reimbursement.reimb_author_id_fk;
        row.appendChild(cell4);

        let cell5 = document.createElement("td");
        cell.innerHTML = ers_reimbursement.reimb_status_id_fk;
        row.appendChild(cell5);

        let cell6 = document.createElement("td");
        cell.innerHTML = ers_reimbursement.reimb_type_id_fk;
        row.appendChild(cell6);

        //append the tr = "row" to the table body (tbody)
        //a new row will be appended FOR ea reimb. returned in fetch() method
        //Select body element using "document."
        document.getElementById("reimbursementBody").appendChild(row);
        }
        //Now, for every reimb. object (a)create a new row, (b)fill it with data, & 
        //(c)add it to the table body
    
    }else {
        //alert cause a popup!!
        alert ("OOh your request failed for some reason:/");
    }

}

//

}
  



