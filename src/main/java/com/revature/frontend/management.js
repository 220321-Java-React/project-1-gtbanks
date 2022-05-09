const url = "http://localhost:3000";


document.getElementById("getAllButton").addEventListener("click", getAll);

//getAll is an asynchronous function which has a fetch request to get reimbursements from our server
//remember, asych makes a function return a promise(which fetch requests return) it is left empty
async function getAll() {

//we will send a fetch req to get all reimb data
//by default, fetch requests send GET req and others like POST)
//The url = http://localhost:3000"+ resource named in Launcher and controller handlers

let response = await fetch(url + "/reimbursements", {
    headers:{"userId":sessionStorage.getItem("user_id")
},
    credentials: "include"}); //afterurl string not in 1st part of video

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
        cell.innerHTML = reimbursement.reimb_id;
        //4.add the td element(data cell) to the tr element (table row)
        //Take this row variable and append a new child to it, which is the td
        row.appendChild(cell);
        
        //5.we do this^^^^for every column in reimb
        let cell2 = document.createElement("td");
        cell2.innerHTML = reimbursement.reimb_amount;
        row.appendChild(cell2);

        let cell3 = document.createElement("td");
        cell3.innerHTML = reimbursement.reimb_submitted;
        row.appendChild(cell3);

        let cell4 = document.createElement("td");
        cell4.innerHTML = reimbursement.reimb_author_id_fk;
        row.appendChild(cell4);

        let cell5 = document.createElement("td");
        cell5.innerHTML = reimbursement.reimb_status_id_fk;
        row.appendChild(cell5);

        let cell6 = document.createElement("td");
        cell6.innerHTML = reimbursement.reimb_type_id_fk;
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