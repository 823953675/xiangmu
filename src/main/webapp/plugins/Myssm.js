var sub=document.getElementsByTagName("#submit");

function fileSelect(){

    console.log("点击");
    // $("<div class='block'></div>").appendTo($("tbody"));
    // $(".block").css({
    //     "width":"600px",
    //     "height":"70px",
    //     "position":"fixed",
    //     "box-sizing":"border-box",
    //     "border-bottom":"5px solid gainsboro",
    //     "background":"#fff",
    //     "z-index":"12",
    //     "text-align":"center",
    //     "line-height":"70px"
    // });
}

sub.onclick=function(){
    alert("确定？");
    fileSelect();
}
