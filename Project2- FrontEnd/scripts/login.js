console.log("fddddddf")



let C = document.getElementById("c");
C.onclick = function(){
    console.log("sddsds");
    window.location.href = "Customer-Register.html";
}


let S = document.getElementById("sregister");
S.onclick = function(){
    console.log("sddsds");
    window.location.href = "Shopper-Register.html";
}
 

let loginForm = document.getElementById("login-form")




loginForm.onsubmit = async function(e){
    e.preventDefault();
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    console.log(username, password)
    

    let response = await fetch(`http://localhost:8080/customerLogin`, {
        method: "POST",
        body: JSON.stringify({
            username: username ,
            password: password
            
        })
    });


    let responseData = await response.json();
    console.log(responseData)


    if(responseData == null){
        alert('Wrong UserName and/or Password!')

    }else{
        sessionStorage.setItem("value", responseData.customerId)
        window.location.href = "Customer-Dashboard.html";
    }



}

let loginForm2 = document.getElementById("login-form2")


loginForm2.onsubmit = async function(e){
    e.preventDefault();
    let username2 = document.getElementById("username2").value;
    let password2 = document.getElementById("password2").value;
    console.log(username2, password2)
    

    let response2 = await fetch(`http://localhost:8080/shopperLogin`, {
        method: "POST",
        body: JSON.stringify({
            username: username2 ,
            password: password2
            
        })
    });


    let responseData2 = await response2.json();
    console.log(responseData2)
    

    if(responseData2 == null){
        alert('Wrong UserName and/or Password!')

    }else{
        sessionStorage.setItem("value1", responseData2.shopperId)
        window.location.href = "Shopper-Dashboard.html";
    }


}

