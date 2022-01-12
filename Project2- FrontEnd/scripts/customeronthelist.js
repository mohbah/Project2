const listid = sessionStorage.getItem("listid");
const listname = sessionStorage.getItem("listname")
const liststatus  = sessionStorage.getItem("liststatus")

if(liststatus == 'Completed'){
    let a = document.getElementById("shoppingForm")
    a.innerHTML = ''
    let b = document.getElementById("deleteForm")
    b.innerHTML= ''

   
    
}


console.log(listname)

let backBtn = document.getElementById("back-btn");
backBtn.onclick = function(){
    window.location.href = "Customer-Dashboard.html";
}

let x = document.getElementById("head")
x.innerText = ` ${listname} => ${liststatus}`

console.log(listid)


let newItemForm = document.getElementById("shoppingForm")

newItemForm.onsubmit = async function(e){
    e.preventDefault();

    let itemName = document.getElementById("addToList").value;
    console.log(itemName)

    let itemQuantity = document.getElementById("quantity").value;
    console.log(itemQuantity)

    let response = await fetch(`http://localhost:8080/item`, {
        method : "POST",
        body : JSON.stringify({
            itemId: null,
            itemName : itemName,
            itemQuantity : itemQuantity,
            shoppingListId : listid      
        })
    });

    let responseData = await response.json();
    console.log(responseData);

    if(responseData.itemId > 0)
        {
            alert('Added Successfully, Refresh your page to see the result!')
        }

}

let deleteItemForm = document.getElementById("deleteForm")

deleteItemForm.onsubmit = async function(e){
    e.preventDefault();

    let itemId = document.getElementById("deleteList").value;
    console.log(itemId)

    let response = await fetch(`http://localhost:8080/item/delete/${itemId}`, {
        method : "DELETE"
    })

    let responseData = await response.json();
    console.log(responseData);
    if (responseData == true){
        alert('Successfuly Deleted!')
    }



}








window.onload = async function(){
    getAllItems();
}

async function getAllItems(){
    let url = `http://localhost:8080/items/${listid}`
    let response = await fetch(url);
    let body = await response.json();
    console.log(body)

    let itemTable = document.getElementById("reimb-table");

    body.forEach(item => {

        let tableRow = document.createElement("tr");

        let dataIdElem = document.createElement("td");
        dataIdElem.innerText = item.itemId;
        tableRow.appendChild(dataIdElem);

        let dataNameElem = document.createElement("td");
        dataNameElem.innerText = item.itemName;
        tableRow.appendChild(dataNameElem);

        let dataQuantityElem = document.createElement("td");
        dataQuantityElem.innerText = item.itemQuantity;
        tableRow.appendChild(dataQuantityElem);


        itemTable.appendChild(tableRow)
    
    });    
       
       

   



}