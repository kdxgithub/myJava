//为所有元素绑定点击事件，用于统计
// $(document).on('click',function (e) {
//    console.log($(e.target));
// });
$(document).ready(function () {
   var app = $("#app")[0];
   var touchstartY;
   app.addEventListener("touchstart",function (ev) {
       var events = ev.touches[0]||ev;
       touchstartY = events.clientY;
   },false);
   app.addEventListener("touchmove",function (ev) {
      var events = ev.touches[0]||ev;
      var clientHeight = document.documentElement.clientHeight;
      var scrollTop = document.body.scrollTop||document.documentElement.scrollTop;
      var scrollHeight = document.body.scrollHeight;
      if(events.clientY>touchstartY&&scrollTop===0&&ev.cancelable){
          ev.preventDefault();
      }else if(scrollTop+clientHeight>scrollHeight&&ev.cancelable){
          ev.preventDefault();
      }
   },false);
});