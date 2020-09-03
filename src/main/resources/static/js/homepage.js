function displayFoods(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);
                //adding an element to the body example
                let elem = document.createElement('div');
                elem.textContent = "hello world";
                document.body.appendChild(elem);

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