function displayMeals(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);
                //adding an element to the body example
                //let elem = document.createElement('div');
                //elem.textContent = "hello world";
                //document.body.appendChild(elem);

                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {
                    // console.log(el); // prints whole element
                    // console.log(el.name); // allows access to specific value

                    // adding title to the body of the page
                    let elem = document.createElement('div');
                    let header = document.createElement('h1');
                    header.textContent = "Meal name: " + el.name;
                    elem.appendChild(header);
                    el.foods.forEach(food => {
                        console.log(food) // print all notes for each notebook
                        let name = document.createElement('p');
                        let cost = document.createElement('p');
                        name.textContent = "Ingredient: " + food.name;
                        cost.textContent = "Cost (£): " + food.cost;
                        elem.appendChild(name);
                        elem.appendChild(cost);
                    })
                    //always do this otherwise it won't be added
                    document.body.appendChild(elem);

                });
            } else {
                console.log(
                    "Looks like its not JSON but lets see what it is... " + req.responseText
                );
            }
        } else {
            console.log("Oh no... handle error");
        }
    };
    req.open("GET", "http://localhost:8080/getAllMeals");
    req.send();
}

function submitFood(){
    let elements = document.getElementById("ingredientForm").elements;
    // create a collection in json format and iterate over it to populate it
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/createFood");
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
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

function createMeal(){
    let elements = document.getElementById("CreateMealForm").elements;
    // create a collection in json format and iterate over it to populate it
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/createMeal");
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({ name: obj.name,
            description: obj.description,
        }
    ));
}






function updateMeal(){
    let elements = document.getElementById("updateMealForm").elements;
    // create a collection in json format and iterate over it to populate it
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }
    const URL = "http://localhost:8080/updateMeal/"+obj.mealId
    const req = new XMLHttpRequest();
    req.open("PUT", URL);
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
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
        if (req.status === 200 && req.readyState == 4) {
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


function deleteMeal(){
    let elements = document.getElementById("deleteMealForm").elements;
    // create a collection in json format and iterate over it to populate it
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    const URL = "http://localhost:8080/deleteMeal/"+obj.mealId

    req.open("DELETE", URL);
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.send();
}
