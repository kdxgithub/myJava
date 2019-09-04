layui.use('element',function () {
    var element = layui.element;
    element.init();
    $("#Account").hide();
    $("#showLeftBody").hide();

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
        $(".layui-body").animate({left:'0px'});
        $("#showLeftBody").show();
        $("#hideLeftBody").hide();
    }
    function showLeftBody() {
        $("#leftBody").animate({width:'200px'});
        $(".layui-body").animate({left:'200px'});
        $("#hideLeftBody").show();
        $("#showLeftBody").hide();
    }
});