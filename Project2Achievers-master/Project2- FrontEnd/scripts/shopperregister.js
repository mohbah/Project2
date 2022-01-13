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
    let age = document.getElementById("age").value;
    console.log(username, password, name,zipcode)

    if(age <21){
    alert('You must be at least 21 years old')
    }else{    
        let response = await fetch(`http://localhost:8080/shopper`, {
        method: "POST",
        body: JSON.stringify({
            shopperName : name ,
            shopperUsername : username,
            shopperPassword : password,
            shopperZipCode : zipcode,
            shopperId : 0            
        })
         });

         let responseData = await response.json();
         console.log(responseData)

          if(responseData.shopperId > 0){
             alert('Account has been created successfully!')
           }else{
          alert('Something went wrong, Try another time!')
           }

}
    
    

    

}
