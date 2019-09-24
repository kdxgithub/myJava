layui.use('table',function () {
    var table = layui.table;

    $("#showTable").on('click',function () {
        table.render({
            elem:'#test3'
            ,url:'[[@{/json/test3.json}]]'
            ,toolbar:true
            ,title:'用户数据表'
            ,totalRow:true
            ,width:892
            ,height:500
            ,align:'center'
            ,cols: [
                [
                    {field:'序号', title:'序号',align:'center', width:80,rowspan:3, fixed: 'left', unresize: true, sort: true, totalRowText: '合计行'}
                    ,{field:'服务场景', title:'服务场景',align:'center', width:90, edit: 'text',rowspan:3}
                    ,{field:'服务名称', title:'服务名称',align:'center', width:90, edit: 'text',rowspan:3}
                    ,{field:'产品名称', title:'产品名称',align:'center', width:90,rowspan:3}
                    ,{field:'需求数量', title:'需求数量',align:'center', width:90, edit: 'text',rowspan:3}
                    ,{field:'套餐选择', title:'套餐选择',align:'center', width:100,colspan:13}
                    ,{field:'使用时长', title:'使用时长',align:'center',width:100,rowspan:3}
                    ,{field:'折扣', title:'折扣',align:'center', width:80,rowspan:3}
                    ,{field:'合计', title:'合计',align:'center', width:100,rowspan:3,totalRow:true}
                ]
                ,[
                    {field:'主套餐',title:'主套餐',align:'center',width:120,colspan:2}
                    ,{field:'配套套餐',title:'配套套餐',align:'center',width:120,colspan:4}
                    ,{field:'可选套餐',title:'可选套餐',align:'center',width:120,colspan:5}
                    ,{field:'可选通讯费',title:'可选通讯费',align:'center',width:120,colspan:2}
                ]
                ,[
                    {field:'套餐类型',title:'套餐类型',align:'center',width:120}
                    ,{field:'主套餐每月资费',title:'主套餐每月资费',align:'center',width:128}
                    ,{field:'出口带宽',title:'出口带宽',align:'center',width:120}
                    ,{field:'出口带宽每月资费',title:'出口带宽每月资费',align:'center',width:148}
                    ,{field:'NAT网关',title:'NAT网关',align:'center',width:120}
                    ,{field:'NAT网关每月资费',title:'NAT网关每月资费',align:'center',width:120}
                    ,{field:'数据盘0.3/G/月',title:'数据盘0.3/G/月月',align:'center',width:120}
                    ,{field:'云存储套餐',title:'云存储套餐',align:'center',width:120}
                    ,{field:'云存储每月资费',title:'云存储每月资费',align:'center',width:141}
                    ,{field:'短信包',title:'短信包',align:'center',width:120}
                    ,{field:'短信包每月资费',title:'短信包每月资费',align:'center',width:120}
                    ,{field:'短信0.1元/条',title:'短信0.1元/条',align:'center',width:120}
                    ,{field:'彩信0.3元/条',title:'彩信0.3元/条',align:'center',width:120}
                ]
            ]
            ,page:true
            ,response:{
                statusCode:200
            }
            ,parseData:function (res) {
                return{
                    "code":res.status,
                    "msg":res.message,
                    "count":res.total,
                    "data":res.rows.item
                };
            }
        });
    });

    $('#addData').on('click',function () {
        var jsonData = JSON.stringify(
            {序号:"10004",服务场景:"hhaha",服务名称:"云考勤"}
        );
        $.ajax({
            type:"post"
            ,url:"addProduct"
            ,dataType:"json"
            ,data:jsonData
            ,contentType:"application/json;charset=utf-8"
            ,success:function (data) {
                console.log(data);
            }
            ,error:function (e) {
                console.log(e);
            }
        });
    });


    $('#outToCsv').on('click',function () {
        table.exportFile(
            ['名字','性别','年龄'],
            [
                ['张山','男','20']
            ],'csv');
    });
    $('#outToExcel').on('click',function () {
        table.exportFile(
            ['名字','性别','年龄'],
            [
                ['张山','男','20']
            ],'xls');
    })
});