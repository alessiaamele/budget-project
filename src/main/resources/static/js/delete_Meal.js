function delete_Meal(){
    let elements = document.getElementById("deleteMealForm").elements;
    let del_meal ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        del_meal[item.name] = item.value;
    }

    const URL = "http://localhost:8080/deleteMeal/" + del_meal.id;
    const req = new XMLHttpRequest();

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
