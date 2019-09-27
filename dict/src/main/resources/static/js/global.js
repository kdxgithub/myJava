$(function () {
    $('#goToAccount').click(function(){
        $('#Account').animate({scrollTop: '0px'}, 800);
    });
    $('#goToSelect').click(function(){
        $('#Select').animate({scrollTop: '0px'}, 800);
    });
});

layui.use('layer',function () {
   var $ = layui.jquery,layer = layui.layer;
   //触发弹窗事件
    var active = {
        confirmTrans:function () {
            var that = this;
            //配置一个透明的询问框
            layer.msg('确定要刷新页面吗？',{
                time:20000,
                btn:['确定','取消'],
                yes:function (index,layero) {
                    console.log("我是确定");
                    // history.go(0);
                },
                btn2:function (index,layero) {
                    console.log("我是取消");
                }
            });
        }
    };

    $("#reload1,#reload2").on('click',function () {
        layer.msg('确定要刷新页面吗？',{
            time:20000,
            icon:6,
            anim:6,
            btn:['确定','取消'],
            yes:function (index,layero) {
                history.go(0);
                layer.close(index);
            }
        });
    });

    // $(":input").on('focus',function () {
    //     var h = window.innerHeight;
    //     $('body').height(h);
    // });
});