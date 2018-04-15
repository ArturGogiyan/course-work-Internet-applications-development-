var login, password;
function signUp() {
setParams();
sendAut('signUp');
}

function signIn() {
setParams();
sendAut('signIn');
}

function setParams() {
    password = document.getElementById("Password").value;
    login = document.getElementById("Login").value;
    // document.getElementById("Password").value = "";
    // document.getElementById("Login").value = "";
}

function sendAut(url) {
    $.get({
        url: url,
        data:{
            password: password,
            login: login
        },
        success: function (data) {
            if(data.indexOf("access")<0 && url.indexOf("In")>0){
                document.location.replace("#main");
                location.reload();
            }
            document.getElementById("response").innerHTML=data;

        },
        error: function () {
            window.alert("WRONG");
        }
    });
}