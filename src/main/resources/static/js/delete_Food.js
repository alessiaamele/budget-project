function delete_Food(){
    let elements = document.getElementById("deleteIngredientForm").elements;
    let del_food ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        del_food[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    const URL = "http://34.89.87.120:8080/deleteFood/" + del_food.id;


    req.open("DELETE", URL);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.send();
}
