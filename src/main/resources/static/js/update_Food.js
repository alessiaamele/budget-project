
function updateFood(){
    let elements = document.getElementById("updateFoodForm").elements;
    // create a collection in json format and iterate over it to populate it
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }
    const URL = "http://localhost:8080/updateFood/"+obj.foodId
    const req = new XMLHttpRequest();
    req.open("PUT", URL);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({
            name: obj.name,
            cost: Number(obj.cost)
        }
    ));
}