var y;
var x;
var r=parseFloat((312/82).toFixed(2));
var rad=312;
var j=1;

function send(type,cx,cy) {
    if(type){
        y = parseFloat(document.getElementById("Y").value);
        r = parseFloat(document.getElementById("radius").value);
    }
    $.get({
        url: "cont",
        data:{
            valueR: r,
            valueX: x,
            valueY: y,
            valueJ: j
        },
        success: function (data) {
           //alert(data.getAttribute("valueR"));

            var canvas = document.getElementById("Img");
            var contextHTML = canvas.getContext("2d");
            if(data.indexOf("true")<150 && data.indexOf("true")>0) contextHTML.fillStyle = "green";
            else contextHTML.fillStyle = "red";
            contextHTML.beginPath();
            contextHTML.arc(cx, cy, 3, 0, 2 * Math.PI, true);
            contextHTML.stroke();
            contextHTML.fill();
            contextHTML.closePath();
            document.getElementById("resultForm").innerHTML=data;

        },
        error: function () {
            window.alert("WRONG");
        }
    });
}
function save(value_x){
    x=value_x;
    document.getElementById("Value_x").value=value_x;
}
function saveR(value_r){
    r=value_r;
    document.getElementById("Value_r").value=value_r;
    changeSize(value_r);
}
function clean(){
    document.getElementById("l_x").style.color="black";
    document.getElementById("l_y").style.color="black";
    document.getElementById("l_r").style.color="black";
}
function isOk(){

    var check_x=true, check_y=true, check_r=true;
    clean();
    y=parseFloat(document.getElementById("Y").value);
    r=parseFloat(document.getElementById("Value_r").value);
    x=parseFloat(document.getElementById("Value_x").value);
    if(isNaN(y)||y===""||y===" "|| y===null || y<=-5 || y>=5){
        document.getElementById("l_y").style.color="red";
        check_y = false;
    }
    if(isNaN(r)||r===""||r===" "|| r===null || r<1 || r>=4){
        document.getElementById("l_r").style.color="red";
        check_r = false;
    }
    if(x===""||isNaN(x)){
        document.getElementById("l_x").style.color="red";
        check_x = false;
    }
    return check_x && check_y && check_r;
}


function defPosition(event) {
    var event = event || window.event;

    // Получаем координаты клика по странице, то есть абсолютные координаты клика.

    // if (document.attachEvent !== null) { // Internet Explorer & Opera
    //     x = window.event.clientX + (document.documentElement.scrollLeft ? document.documentElement.scrollLeft : document.body.scrollLeft);
    //     y = window.event.clientY + (document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop);
    // } else if (!document.attachEvent && document.addEventListener) { // Gecko
        x = event.clientX + window.scrollX;
        y = event.clientY + window.scrollY;
    // }
    //Определяем границы объекта, в нашем случае картинки.
    var elem=document.getElementById("Img");
    var top=0, left=0;
    while(elem) {
        top = top + parseFloat(elem.offsetTop);
        left = left + parseFloat(elem.offsetLeft);
        elem = elem.offsetParent
    }
    if((x-left-rad<=rad)&&(y-top-rad<=rad)) {
        var cx=x-left, cy=y-top;

        // Пересчитываем координаты и выводим их алертом.
        x = parseFloat(((x - left - rad) / 82).toFixed(2));
        y = parseFloat(((top + rad - y) / 82).toFixed(2));
        send(0,cx,cy);
    }
}
function changeSize(rr) {
    if(isNaN(rr)||rr===""||rr===" "|| rr===null || rr<=0){
        document.getElementById("l_r").style.color="red";
    }else {
        var canvas = document.getElementById("Img");
        var contextHTML = canvas.getContext("2d");
        contextHTML.width=rr*164;
        contextHTML.height=rr*164;
        contextHTML.fillStyle = "#17806d";
        contextHTML.fillRect(0, 0, canvas.width, canvas.height);
        contextHTML.fillStyle = "black";
        // contextHTML.style().width=400;
        // contextHTML.style().height=400;
        var img = new Image;
        img.src="resources/scripts/areas.png";
        contextHTML.drawImage(img,0,0,rr*164,rr*164);
        document.getElementById("l_r").style.color="black";
        // document.getElementById("Img").width = rr * 164;
        // document.getElementById("Img").height = rr * 164;

        rad=rr*82;
        r=rr;
    }
}
function  checkY() {
    var yy = parseFloat(document.getElementById("Y").value);
    if(isNaN(yy)||yy===""||yy===" "|| yy===null || yy<=-5 || yy>=5){
        document.getElementById("l_y").style.color="red";
    }else{
        document.getElementById("l_y").style.color="black";
    }
}