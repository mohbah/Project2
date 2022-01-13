let backBtn = document.getElementById("back-btn");
backBtn.onclick = function(){
    window.location.href = "Shopper-Dashboard.html";
}

const listid = sessionStorage.getItem("listid");
const listname = sessionStorage.getItem("listname")
const shopperID = sessionStorage.getItem("shopperid")


let u = document.getElementById("head")
u.innerHTML= ''
u.innerText = ` ${listname} `

window.onload = async function(){
    getAllItems();
}








let x = document.getElementById("t");
x.onclick = async function(){
    
    
    
    

    let response = await fetch(`http://localhost:8080/shoppers/${shopperID}/${listid}`,{
        method : "PATCH"
    })

    
    alert("Successfully Selected!")
    



}




let decline = document.getElementById("decline-list-form")

decline.onsubmit = async function(e){
    e.preventDefault();

    let shoppercomment = document.getElementById("shopper-comment").value;
    console.log(shoppercomment);

    let response = await fetch(`http://localhost:8080/shoppers/${listid}`, {
        method : "PATCH",
        body : JSON.stringify({
            comment : shoppercomment,
            
        })



    })
    alert("Successfully Declined!")
    window.location.href = "Shopper-Dashboard.html";




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


