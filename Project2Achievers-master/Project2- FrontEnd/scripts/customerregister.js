let backBtn = document.getElementById("back-btn");
backBtn.onclick = function(){
    window.location.href = "index.html";
}

let registerform = document.getElementById("login-form")

registerform.onsubmit = async function(e){
    e.preventDefault();
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let name = document.getElementById("name").value;
    let zipcode = document.getElementById("zipcode").value;
    console.log(username, password, name,zipcode)
    
    

    let response = await fetch(`http://localhost:8080/customer`, {
        method: "POST",
        body: JSON.stringify({
            customerName : name ,
            customerUsername : username,
            customerPassword : password,
            customerZipCode : zipcode,
            cusomerId : 0            
        })
    });

    let responseData = await response.json();
    console.log(responseData)

    if(responseData == null){
        alert('This UserName is already used!')

    }else{
        alert('Account has been created successfully!')
    }

    

   
}

