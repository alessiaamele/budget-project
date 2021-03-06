function updateMeal(){
    let elements = document.getElementById("updateMealForm").elements;
    // create a collection in json format and iterate over it to populate it
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }
    const URL = "http://localhost/updateMeal/"+obj.mealId
    const req = new XMLHttpRequest();
    req.open("PUT", URL);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {tel
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({
            name: obj.name,
            description: obj.description
        }
    ));
}