let block = document.getElementsByClassName("text")[0];

fetch('http://localhost:8081/users')
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        data.forEach(element => {
            block.innerHTML += `<p> <a href = 'request.html?&${element.id}'>` + element.nickname + "</a> (" + element.email +  ")</p>" ;
        });
        localStorage.setItem("users", JSON.stringify(data));
    });
