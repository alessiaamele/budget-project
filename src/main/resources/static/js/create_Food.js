function submitFood(){
    let elements = document.getElementById("ingredientForm").elements;
    // create a collection in json format and iterate over it to populate it
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    req.open("POST", "http://localshost:8080/createFood");
    const req = new XMLHttpRequest();

    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({ name: obj.name,
            cost: obj.cost,
            meal:{
                id: Number(obj.mealId)}
        }
    ));
}