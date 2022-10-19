


var url = "/heartData?";
var i=0;
function sliderChange(val){

    var slideList = document.querySelectorAll(".slide");
    slideList.forEach(element => {
        console.log(document.querySelector(".tpc"+i).innerText)
        url=url + document.querySelector(".tpc"+i).innerText + "=" + element.getElementsByTagName("p")[0].innerText+"&";
        i++;

    });

    window.location.href=url;
    window.location.replace(url.substring(0, url.length-1));
    // console.log(rangeList); 
    url="/";
}
