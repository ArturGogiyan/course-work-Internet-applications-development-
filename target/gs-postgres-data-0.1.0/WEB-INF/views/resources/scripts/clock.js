window.onload = function(){

    window.setTimeout(
        function(){
            displayC();
        }
        , 50);
};
function displayC(){
    var canvasHTML = document.getElementById("Img");
    var contextHTML = canvasHTML.getContext('2d');
    var img = new Image;
    img.src="resources/scripts/areas.png";
    contextHTML.drawImage(img,0,0,4*156,4*156);
}