let logoutBtn = document.getElementById("logout-btn");
logoutBtn.onclick = function(){
    window.location.href = "index.html";
}
const CustomerID = sessionStorage.getItem("value");

let deactivatebtn = document.getElementById("deactivate")

deactivatebtn.onclick= async function(){
    if(confirm("Are you sure you want to delete your account?")){

    let deletelist = await fetch(`http://localhost:8080/customer/${CustomerID}`,{
        method : "DELETE"
    })

    window.location.href = "index.html";


    }else{}

}



let newlistForm = document.getElementById("create-list-form")

newlistForm.onsubmit = async function(e){
    e.preventDefault();

    let listname = document.getElementById("listname").value;
    console.log(listname);

    let customercomment = document.getElementById("Customer-comment").value;
    console.log(customercomment);

    let response = await fetch(`http://localhost:8080/shoppingList`, {
        method : "POST",
        body : JSON.stringify({
            shoppingListId: null,
            shoppingListName : listname,
            customerComments : customercomment,
            shoppercomments : null,
            listStatus : null,
            customerId : CustomerID,
            shopperId : null
        })
        
    })
    console.log(response)


}



window.onload = async function(){
    getAllLists();
}


async function getAllLists(){
    let url = `http://localhost:8080/lists/${CustomerID}`
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

        let  liststatuselement = document.createElement("div");
        liststatuselement.className = "list-status"
        liststatuselement.innerText = element.listStatus;


        let  btncontrolelement = document.createElement("div")

        let viewbtnelement = document.createElement("button")
        viewbtnelement.innerText = "View"
        viewbtnelement.className = "btn btn-primary"
        viewbtnelement.id = "view-btn"


        let deletebtnelement = document.createElement("button")
        deletebtnelement.innerText = "Delete"
        deletebtnelement.className = "btn btn-danger"
        deletebtnelement.id = "delete-btn"

        btncontrolelement.appendChild(viewbtnelement)
        btncontrolelement.appendChild(deletebtnelement)

        cardelement.appendChild(listnameelement)
        cardelement.appendChild(liststatuselement)
        cardelement.appendChild(btncontrolelement)

        shoppinglistelem.appendChild(cardelement)


        viewbtnelement.onclick = function(){
            sessionStorage.setItem("listid", element.shoppingListId)
            sessionStorage.setItem("listname", element.shoppingListName)
            sessionStorage.setItem("liststatus", element.listStatus)
            window.location.href = "Customer-on-the-list.html";
        }


        deletebtnelement.onclick = async function(){
            let deletelist = await fetch(`http://localhost:8080/list/delete/${element.shoppingListId}`,{
                method : "DELETE"
            })
            console.log(deletelist)
            if (deletelist.ok == true){
                alert('Successfuly Deleted!')
            }
           
        }






        
    });
    
    
}

let pendingBtn = document.getElementById("incompleted");
pendingBtn.onclick = async function(e){
    e.preventDefault();

    
    let url = `http://localhost:8080/lists/incomplete/${CustomerID}`
    let response = await fetch(url);
    let lists = await response.json();
    console.log(lists)

    let shoppinglistelem2 = document.getElementById("grocery-container")
    shoppinglistelem2.innerHTML = ''

    lists.forEach(element => {
        console.log(element)

        let cardelement = document.createElement("div");
        cardelement.className = "list-card"

        let listnameelement = document.createElement("div");
        listnameelement.className = "list-name"
        listnameelement.innerText = element.shoppingListName;

        let  liststatuselement = document.createElement("div");
        liststatuselement.className = "list-status"
        liststatuselement.innerText = element.listStatus;


        let  btncontrolelement = document.createElement("div")

        let viewbtnelement = document.createElement("button")
        viewbtnelement.innerText = "View"
        viewbtnelement.className = "btn btn-primary"
        viewbtnelement.id = "view-btn"


        let deletebtnelement = document.createElement("button")
        deletebtnelement.innerText = "Delete"
        deletebtnelement.className = "btn btn-danger"
        deletebtnelement.id = "delete-btn"

        btncontrolelement.appendChild(viewbtnelement)
        btncontrolelement.appendChild(deletebtnelement)

        cardelement.appendChild(listnameelement)
        cardelement.appendChild(liststatuselement)
        cardelement.appendChild(btncontrolelement)

        

        shoppinglistelem2.appendChild(cardelement)
        


        deletebtnelement.onclick = async function(){
            let deletelist = await fetch(`http://localhost:8080/list/delete/${element.shoppingListId}`,{
                method : "DELETE"
            })
            console.log(deletelist)
            if (deletelist.ok == true){
                alert('Successfuly Deleted!')
            }
           
        }






        
    });

}

    let allBtn = document.getElementById("all");
    allBtn.onclick = async function(e){
        e.preventDefault();
    
        
        let url = `http://localhost:8080/lists/${CustomerID}`
        let response = await fetch(url);
        let lists = await response.json();
        console.log(lists)
    
        let shoppinglistelem2 = document.getElementById("grocery-container")
        shoppinglistelem2.innerHTML = ''
    
        lists.forEach(element => {
            console.log(element)
    
            let cardelement = document.createElement("div");
            cardelement.className = "list-card"
    
            let listnameelement = document.createElement("div");
            listnameelement.className = "list-name"
            listnameelement.innerText = element.shoppingListName;
    
            let  liststatuselement = document.createElement("div");
            liststatuselement.className = "list-status"
            liststatuselement.innerText = element.listStatus;
    
    
            let  btncontrolelement = document.createElement("div")
    
            let viewbtnelement = document.createElement("button")
            viewbtnelement.innerText = "View"
            viewbtnelement.className = "btn btn-primary"
            viewbtnelement.id = "view-btn"
    
    
            let deletebtnelement = document.createElement("button")
            deletebtnelement.innerText = "Delete"
            deletebtnelement.className = "btn btn-danger"
            deletebtnelement.id = "delete-btn"
    
            btncontrolelement.appendChild(viewbtnelement)
            btncontrolelement.appendChild(deletebtnelement)
    
            cardelement.appendChild(listnameelement)
            cardelement.appendChild(liststatuselement)
            cardelement.appendChild(btncontrolelement)
    
            
    
            shoppinglistelem2.appendChild(cardelement)
            
    
    
            deletebtnelement.onclick = async function(){
                let deletelist = await fetch(`http://localhost:8080/list/delete/${element.shoppingListId}`,{
                    method : "DELETE"
                })
                console.log(deletelist)
                if (deletelist.ok == true){
                    alert('Successfuly Deleted!')
                }
               
            }
    
    
    
    
    
    
            
          });


          let allBtn = document.getElementById("completed");
          allBtn.onclick = async function(e){
              e.preventDefault();
          
              
              let url = `http://localhost:8080/lists/complete/${CustomerID}`
              let response = await fetch(url);
              let lists = await response.json();
              console.log(lists)
          
              let shoppinglistelem2 = document.getElementById("grocery-container")
              shoppinglistelem2.innerHTML = ''
          
              lists.forEach(element => {
                  console.log(element)
          
                  let cardelement = document.createElement("div");
                  cardelement.className = "list-card"
          
                  let listnameelement = document.createElement("div");
                  listnameelement.className = "list-name"
                  listnameelement.innerText = element.shoppingListName;
          
                  let  liststatuselement = document.createElement("div");
                  liststatuselement.className = "list-status"
                  liststatuselement.innerText = element.listStatus;
          
          
                  let  btncontrolelement = document.createElement("div")
          
                  let viewbtnelement = document.createElement("button")
                  viewbtnelement.innerText = "View"
                  viewbtnelement.className = "btn btn-primary"
                  viewbtnelement.id = "view-btn"
          
          
                  let deletebtnelement = document.createElement("button")
                  deletebtnelement.innerText = "Delete"
                  deletebtnelement.className = "btn btn-danger"
                  deletebtnelement.id = "delete-btn"
          
                  btncontrolelement.appendChild(viewbtnelement)
                  btncontrolelement.appendChild(deletebtnelement)
          
                  cardelement.appendChild(listnameelement)
                  cardelement.appendChild(liststatuselement)
                  cardelement.appendChild(btncontrolelement)
          
                  
          
                  shoppinglistelem2.appendChild(cardelement)
                  
          
          
                  deletebtnelement.onclick = async function(){
                      let deletelist = await fetch(`http://localhost:8080/list/delete/${element.shoppingListId}`,{
                          method : "DELETE"
                      })
                      console.log(deletelist)
                      if (deletelist.ok == true){
                          alert('Successfuly Deleted!')
                      }
                     
                  }
          
          
          
          
          
          
                  
                });
            }      
    

    
    

}
