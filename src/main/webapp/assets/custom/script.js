function checkPassword() {
    var first = document.getElementById("pass1").value;
    var second = document.getElementById("pass2").value;
    if(first!==second && first!=="" && second!=="") document.getElementById("holder").innerHTML="entered passwords are different";
    else document.getElementById("holder").innerHTML="";
}
function calculateCost() {
    $.get({
        url:"calculateCost",
        data:{
            firstPlanet: document.getElementById("firstPlanet").value,
            secondPlanet: document.getElementById("secondPlanet").value,
            weight: document.getElementById("weight").value,
            cargoType: document.getElementById("cargoType").value
        },
        success: function(data){
            document.getElementById("cost").innerHTML=data;
        },
        error: function(jqxhr, status, errorMsg) {
            window.alert(status+"|"+errorMsg);
        }
    })

}