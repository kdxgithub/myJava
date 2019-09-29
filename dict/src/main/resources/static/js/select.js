layui.use('element',function () {
    var element = layui.element;
    element.init();
    $("#Account").hide();
    $("#showLeftBody").hide();
    $("#leftBody").css("width",100+"px");
    $(".layui-body").css("left",100+"px");
    $(".layui-footer").css("left",100+"px");

    //隐藏和显示侧边栏
    $("#hideLeftBody").on('click',function () {
        hideLeftBody();
    });
    $("#showLeftBody").on('click',function () {
        showLeftBody();
    });
    //绑定事件,隐藏或显示查询和报账系统
    $("#selectProduct").on('click',function () {
        $("#Account").hide();
        $("#Select").show();
        hideLeftBody();
    });
    $("#accountProduct").on('click',function () {
        $("#Account").show();
        $("#Select").hide();
        hideLeftBody();
    });

    function hideLeftBody() {
        $("#leftBody").animate({width:'0px'});
        $("#Select").animate({left:'0px'});
        $("#Account").animate({left:'-15px'});
        $(".layui-footer").animate({left:'0px'});
        $("#showLeftBody").show();
        $("#hideLeftBody").hide();
    }
    function showLeftBody() {
        $("#leftBody").animate({width:'100px'});
        $("#Select").animate({left:'100px'});
        $("#Account").animate({left:'85px'});
        $(".layui-footer").animate({left:'0px'});
        $("#hideLeftBody").show();
        $("#showLeftBody").hide();
    }

});