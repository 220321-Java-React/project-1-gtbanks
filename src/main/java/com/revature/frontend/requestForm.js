const url = "http://localhost:3000";


document.getElementById("submitButton").addEventListener("click", createReimbursement);

async function createReimbursement() {
    let amount = document.getElementById("expense").value;
    var reimbursementType;
    let type1 = document.getElementById("type1").value;
    let type2 = document.getElementById("type2").value;
    let type3 = document.getElementById("type3").value;
    let type4 = document.getElementById("type4").value;
   if(type1.checked == true) {
       reimbursementType = type1.value;
   }
   if(type2.checked == true) {
    reimbursementType = type2.value;
}
if(type3.checked == true) {
    reimbursementType = type3.value;
}
if(type4.checked == true) {
    reimbursementType = type4.value;
}
    let reimbursement = {
        reimb_amount:amount,
        reimb_type_id_fk: reimbursementType
    }
    let response = await fetch(url+"/reimbursements", {
        headers:{"userId":sessionStorage.getItem("user_id")},
        method: "POST", //send a POST req (GET is the default verb)
        body: JSON.stringify(reimbursement),
        credentials: "include"
        //Last line will ensure the cookie is captured(so we can have a session)
        //future fetches after login will require this "include" value
    })
    if(response.status == 201) {
        window.location.href = 'http://127.0.0.1:5500/src/main/java/com/revature/frontend/Staff.html';
    }
}