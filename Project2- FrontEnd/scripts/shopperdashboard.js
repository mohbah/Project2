let logoutBtn = document.getElementById("logout-btn");
logoutBtn.onclick = function(){
    window.location.href = "index.html";
}


const shopperID = sessionStorage.getItem("value1");

let deactivatebtn = document.getElementById("deactivate")

deactivatebtn.onclick= async function(){
    if(confirm("Are you sure you want to delete your account?")){

    let deletelist = await fetch(`http://localhost:8080/shopper/${shopperID}`,{
        method : "DELETE"
    })

    window.location.href = "index.html";


    }else{}

}





console.log(shopperID)

window.onload = async function(){
    getAllLists();
}


async function getAllLists(){
    let url = `http://localhost:8080/lists`
    let response = await fetch(url);
    let lists = await response.json();
    

    let shoppinglistelem = document.getElementById("grocery-container")

    lists.forEach(element => {
        console.log(element)
        

        

        let cardelement = document.createElement("div");
        cardelement.className = "list-card"

        let listnameelement = document.createElement("div");
        listnameelement.className = "list-name"
        listnameelement.innerText = element.shoppingListName;

        


        let  btncontrolelement = document.createElement("div")

        let viewbtnelement = document.createElement("button")
        viewbtnelement.innerText = "View"
        viewbtnelement.className = "btn btn-success"
        viewbtnelement.id = "view-btn"

        if(element.shopperId > 0)
        {
            let completeelement = document.createElement("button")
            completeelement.innerText = "Complete"
            completeelement.className = "btn btn-danger"
            completeelement.id = "delivered-btn"
            btncontrolelement.appendChild(completeelement)

            completeelement.onclick= async function(e){

                e.preventDefault();

                
            
                let response = await fetch(`http://localhost:8080/list/update/${element.shoppingListId}`, {
                    method : "POST"
                                          
                    })
            
            
            
                
                alert("Successfully Delivered!")
            


            }

        }


        
        
        btncontrolelement.appendChild(viewbtnelement)
        

        cardelement.appendChild(listnameelement)
        
        cardelement.appendChild(btncontrolelement)

        shoppinglistelem.appendChild(cardelement)


        viewbtnelement.onclick = function(){
            sessionStorage.setItem("listid", element.shoppingListId)
            sessionStorage.setItem("listname", element.shoppingListName)
            sessionStorage.setItem("shopperid", shopperID)
            window.location.href = "Shopper-on-the-list.html";
        }


        


        






        
    });
    
    
}