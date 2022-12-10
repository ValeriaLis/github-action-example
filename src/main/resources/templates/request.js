let id = window.location.href;
console.log(125);
id = id.slice(id.indexOf("?&")+2);

let arr = JSON.parse(localStorage.getItem("users"));
arr.forEach(element => {
    if (element.id == id) {
        document.getElementsByTagName("title")[0].innerText = "Information for " + element.nickname;
        document.getElementsByClassName("text")[0].innerHTML = "<p> <a href='index.html'>" + element.nickname + "</p>";
        document.getElementsByClassName("request-left")[0].innerHTML = "<p> Requsts left:" + element.prem.request + "</p>";

    }
});

function clickOnMyBtn() {
    let requsts = document.getElementsByClassName("request-left")[0].innerText;
    requsts = Number(requsts.slice(requsts.indexOf(":") + 1)) - 1;
    if (requsts === -1) {
        return;
    }
    document.getElementsByClassName("request-left")[0].innerHTML = "<p>Requsts left:" + requsts + "</p>";
    console.log(255);
    fetch('http://localhost:8081/valuta')
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            let eurBuy = Number(data[0].buy).toFixed(2);
            let eurSale = Number(data[0].sale).toFixed(2);
            let usdBuy = Number(data[1].buy).toFixed(2);
            let usdSale = Number(data[1].sale).toFixed(2);

            document.getElementsByClassName("currency")[0].innerHTML = "<p>EUR buy:" + eurBuy + "&nbsp;sale:" + eurSale + "</p>";
            document.getElementsByClassName("currency")[0].innerHTML += "<p>USD buy:" + usdBuy + "&nbsp;sale:" + usdSale + "</p>";
        });

}
