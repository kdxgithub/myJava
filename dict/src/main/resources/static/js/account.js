//全局变量
//--云桌面--start--全局变量
var yun_desktop_EBW;//云桌面--出口宽带选项
var yun_desktop_NGW;//云桌面--Nat网关选项
var yun_desktop_DS;//云桌面--数据盘选项
var q_EBW; //记录 出口宽带选项 的 html代码
var q_NGW; //记录 Nat网关选项 的 html代码
var q_DS; //记录 数据盘选项的 html代码
var q_EBW_NGW; // 记录所有选项的 html代码
//--云桌面--end--全局变量
//--云办公--start--全局变量
var yun_office_ChatCost; //云办公--通讯费选项
var q_ChatCost; //记录 云办公 通讯费选项的 html代码
//--云办公--end--全局变量
//--云监控--start--全局变量
var yun_monitoring_CloudStorageCost; //云监控--云存储选项
var q_CloudStorageCost; //记录 云监控--云存储选项的html代码
//--云监控--end--全局变量
//--云客服--start--全局变量
var yun_customer_SMS;//云客服--短信包选项
var q_CSMS;//记录 云客服--短信包选项的 html 代码
//--云客服--end--全局变量
var productInfo;
var priceCounts;
var AllPriceCounts = 0.0;
var number=0;//记录添加的产品序号
var outThead="";
var outTbody="";

$(document).ready(function () {
    //初始化
    //云桌面--选项隐藏
    yun_desktop_EBW = $("#ExportBandWidth").detach();
    yun_desktop_NGW = $("#NATGateWay").detach();
    yun_desktop_DS = $("#DataSet").detach();
    q_EBW =
        "<div class='layui-form-item' id='ExportBandWidth'>"+
        yun_desktop_EBW.html()+"</div>";
    q_NGW =
        "<div class='layui-form-item' id='NATGateWay'>"+
        yun_desktop_NGW.html()+"</div>";
    q_DS =
        "<div class='layui-form-item' id='DataSet'>"+
        yun_desktop_DS.html()+"</div>";
    q_EBW_NGW = q_EBW + q_NGW + q_DS;
    //云办公 -- 初始化
    yun_office_ChatCost = $("#yun_office_ChatCost").detach();
    q_ChatCost =
        "<div class='layui-form-item' id='yun_office_ChatCost'>"+
        yun_office_ChatCost.html()+"</div>";
    //云监控 -- 初始化
    yun_monitoring_CloudStorageCost = $("#yun_monitoring_CloudStorageCost").detach();
    q_CloudStorageCost =
        "<div class='layui-form-item' id='yun_monitoring_CloudStorageCost'>"+
        yun_monitoring_CloudStorageCost.html()+"</div>";
    //云客服 -- 初始化
    yun_customer_SMS = $("#yun_customer_SMS").detach();
    q_CSMS =
        "<div class='layui-form-item' id='yun_customer_SMS'>"+
        yun_customer_SMS.html()+"</div>";
});
layui.use(['form','table','element'],function () {
    var form = layui.form;
    var table = layui.table;
    var element = layui.element;
    var count = 0;
    //监听提交
    // form.on('submit(formDemo)',function(data){
    //     priceCounts = JSON.stringify(data.field);
    //     $("#priceCounts").append(priceCounts+"\n");
    //     // var _priceCounts = JSON.parse(priceCounts);
    //     // var tableThString="";
    //     // var tableTrString="";
    //     // number++;
    //     // if(tableTrString !== null && tableThString !== null){
    //     //     if(_priceCounts.hasOwnProperty("出口带宽每月资费")){
    //     //         _priceCounts.产品套餐每月资费 =parseInt(_priceCounts.出口带宽每月资费)
    //     //             +parseInt(_priceCounts.产品套餐每月资费);
    //     //     }
    //     //     if(_priceCounts.hasOwnProperty("NET网关每月资费")){
    //     //         _priceCounts.产品套餐每月资费 =parseInt(_priceCounts.NET网关每月资费)
    //     //             +parseInt(_priceCounts.产品套餐每月资费);
    //     //     }
    //     //     if(_priceCounts.hasOwnProperty("云存储")){
    //     //         _priceCounts.产品套餐每月资费 =parseInt(_priceCounts.云存储)
    //     //             +parseInt(_priceCounts.产品套餐每月资费);
    //     //     }
    //     //     if(_priceCounts.hasOwnProperty("短信包")){
    //     //         _priceCounts.产品套餐每月资费 =parseInt(_priceCounts.短信包)
    //     //             +parseInt(_priceCounts.产品套餐每月资费);
    //     //     }
    //     //     var counts = _priceCounts.需求数量*_priceCounts.产品套餐每月资费
    //     //         *_priceCounts.使用时长*_priceCounts.折扣/100;
    //     //     AllPriceCounts = AllPriceCounts+counts;
    //     //     $("#AllPriceCounts").html("合计："+AllPriceCounts+"元");
    //     // }
    //     count++;
    //     return false;
    // });

    //二级联动下拉列表：服务名称选择
    form.on('select(product1)',function () {
        var optionstring = "";
        var product1 = $("#product1").val();
        $.ajax({
            type:'POST',
            url:'getSecondList',
            dataType:'json',
            async:true,
            success:function (second) {
                if(second == null){
                    alert("没有数据");
                }else{
                    for(var i=0;i<second.length;i++){
                        if(second[i].scopeName == product1){
                            optionstring += "<option value='"+second[i].serviceName+"'>"+second[i].serviceName+"</option>";
                        }
                    }
                    $("#product2").html("<option value='' selected>请选择服务名称</option>"+optionstring);
                    form.render('select');
                }
            }
        });
    });

    //三级联动下拉列表：具体产品选择
    form.on('select(product2)',function () {
        var optionstring = "";
        var product2 = $("#product2").val();
        $.ajax({
            type:'POST',
            url:'getThirdList',
            dataType:'json',
            async:true,
            success:function (third) {
                if(third == null){
                    alert("没有数据");
                }else{
                    for(var i=0;i<third.length;i++){
                        if(third[i].serviceName == product2){
                            optionstring += "<option value='"+third[i].productName+"'>"+third[i].productName+"</option>";
                        }
                    }
                    $("#product3").html("<option value='' selected>请选择产品名称</option>"+optionstring);
                    form.render('select');
                }
            }
        });
    });

    //四级联动下拉列表：产品套餐选择
    /**
     * 流程思想：根据产品名称的编号 productId 和 isPrice 来展示对应的产品套餐选择
     * 1、判断 isPrice 是否为 1（代表产品是否有资费说明）
     *      如果为 1 ，展示产品的套餐选择方案，如果还有附加方案，应添加相应选择框
     *          2、判断 productId，
     *      如果不为 1，设置产品的的套餐选择为 “按项目方案报价”，并让用户输入每月费用
     *
     */
    form.on('select(product3)',function () {
        var optionstring = "";
        var product3 = $("#product3").val();
        $.ajax({
            type:'POST',
            url:'getIsStandardProduct?productName='+product3,
            dataType:'json',
            async:true,
            success:function (isStandard) {
                if(isStandard == null){
                    alert("没有数据");
                }else{
                    hideAllisPrice();//隐藏所有 isPrice == 1 的产品选项
                    if(isStandard.isPrice == 0){
                        productInfo += "<option value='按项目方案报价'>按项目方案报价</option>";
                    }else{ //isStandard.isPrice == 1
                        //2、根据 productId 确定需要显示的产品选项
                        if(isStandard.productId == "1011301"){
                            //云桌面
                            show_yun_desktop();
                        }else if(isStandard.productId == "1011401"){
                            //综合办公
                            show_yun_office();
                        }else if(isStandard.productId == "1011501"){
                            //手机看店
                            show_yun_monitoring();
                        }else if(isStandard.productId == "1011601"){
                            //天翼对讲
                            show_yun_dialogue();
                        }else if(isStandard.productId == "1011701"){
                            //翼讯通
                            show_yun_newsletter();
                        }else if(isStandard.productId == "1033101"){
                            //云名片--闪信
                            show_yun_card_flashletter();
                        }else if(isStandard.productId == "1033102"){
                            //云名片--集团彩信
                            show_yun_card_MMS();
                        }else if(isStandard.productId == "1033201"){
                            //云客户--旺铺助手
                            show_yun_customer_assistant();
                        }else if(isStandard.productId == "1044301"){
                            //云管家--云管家
                            show_yun_housekeeper();
                        }
                        else {

                        }
                    }
                }
                $("#product4").html("<option value='' selected>请选择一个产品套餐</option>"+productInfo);
                form.render();
                productInfo = "";
            }
        });
    });

    //五级联动输出框：资费情况说明
    form.on('select(product4)',function () {
        var optionstring = "";
        var product4 = $("#product3").val();
        var product5 = $("#product4").val();
        $.ajax({
            type:'POST',
            url:'getIsStandardProduct?productName='+product4,
            dataType:'json',
            async:true,
            success:function (isStandard) {
                if(isStandard == null){
                    alert("没有数据");
                }else{
                    if(isStandard.isPrice == 0){
                        $("#priceCount").removeAttr("disabled");
                        $("#priceCount").val("");
                        $("#priceCount").attr("placeholder","请输入每月收费");
                    }else{
                        $("#priceCount").attr("disabled","disabled");
                        $("#priceCount").attr("placeholder","展示资费情况");
                        var value = product5.match(/\d+/);
                        $("#priceCount").val(value);
                    }
                }
            }
        });
    });
    //六级联动----云桌面----NAT网关
    form.on('select(NGW)',function () {
        var ngwValue = $("#NGW").val();
        var ngwValueNum = ngwValue.match(/\d+/)*30;
        $("#NGWpriceCount").val(ngwValueNum);
    });
    //六级联动----云监控
    form.on('select(CSC)',function () {
        var CSC = $("#CSC").val();
        var CSCNum = CSC.match(/\d+/);
        $("#CSCpriceCount").val(CSCNum);
    });
    //六级联动----云客服
    form.on('select(CSMS)',function () {
        var CSMS = $("#CSMS").val();
        var CSMSNum = CSMS.match(/\d+/);
        $("#CSMSpriceCount").val(CSMSNum);
    });
});

//    方法区-------------------
//隐藏所有 isPrice == 1 的 产品
function hideAllisPrice() {
    $("#yun_temp").empty();
}
//云桌面  ---显示
function show_yun_desktop() {
    //云桌面
    $("#yun_temp").html(q_EBW_NGW);
    //云桌面---出口带宽
    $("#EBW").on("input",function (e) {
        var EBWpriceCount = e.delegateTarget.value;
        if(EBWpriceCount<=5 && EBWpriceCount>0){
            $("#EBWpriceCount").val(EBWpriceCount*20);
        }else if(EBWpriceCount>5){
            $("#EBWpriceCount").val(EBWpriceCount*36);
        }else {
            $("#EBWpriceCount").attr('placeholder',"请输入正确的带宽");
        }
    });
    productInfo +=
        "<optgroup label='云桌面基础配置'>" +
        "<option value='标准型204元/月：2VPU,4GB内存，80GB系统盘SAS，操作系统Windows  Server 2008 R2 含Windows 7 体验桌面'>" +
        "标准型204元/月：2VPU,4GB内存，80GB系统盘SAS，操作系统Windows  Server 2008 R2 含Windows 7 体验桌面" +
        "</option>" +
        "<option value='高配型380元/月：4VPU,8GB内存，80GB系统盘SAS，操作系统Windows  Server 2008 R2 含Windows 7 体验桌面'>" +
        "高配型380元/月：4VPU,8GB内存，80GB系统盘SAS，操作系统Windows  Server 2008 R2 含Windows 7 体验桌面" +
        "</option>" +
        "<option value='旗舰型691元/月：8VPU,16GB内存，80GB系统盘SAS，操作系统Windows  Server 2008 R2 含Windows 7 体验桌面'>" +
        "旗舰型691元/月：8VPU,16GB内存，80GB系统盘SAS，操作系统Windows  Server 2008 R2 含Windows 7 体验桌面" +
        "</option>" +
        "</optgroup>";
}
//云办公 ---显示
function show_yun_office() {
    $("#yun_temp").html(q_ChatCost);
    productInfo +=
        "<optgroup label='功能费用'>" +
        "<option value='通用版10元/月/户'>" +
        "通用版10元/月/户" +
        "</option>" +
        "<option value='党建版15元/月/户'>" +
        "党建版15元/月/户" +
        "</option>" +
        "</optgroup>";
}
// 云监控 -- 手机看店
function show_yun_monitoring() {
    $("#yun_temp").html(q_CloudStorageCost);
    productInfo +=
        "<optgroup label='摄像头/烟感终端租赁费'>" +
        "<option value='20元/端/月，迷你小达WIFI摄像机 SD-IPC5200-WIR-F，租赁期24个月'>" +
        "20元/端/月，迷你小达WIFI摄像机 SD-IPC5200-WIR-F，租赁期24个月" +
        "</option>" +
        "<option value='20元/端/月，NB独立烟雾探测器（已含NB卡）JTY-GF-XF9132，租赁期24个月'>" +
        "20元/端/月，NB独立烟雾探测器（已含NB卡）JTY-GF-XF9132，租赁期24个月" +
        "</option>" +
        "<option value='30元/端/月，130万高清半球摄像机 SD-IPC3560-IR-F，租赁期24个月'>" +
        "30元/端/月，130万高清半球摄像机 SD-IPC3560-IR-F，租赁期24个月" +
        "</option>" +
        "<option value='45元/端/月，200万高清半球摄像机 SD-IPC3580-IR-F，租赁期24个月'>" +
        "45元/端/月，200万高清半球摄像机 SD-IPC3580-IR-F，租赁期24个月" +
        "</option>" +
        "<option value='45元/端/月，200万高清云台机 SD-IPC6001-WIR-F，租赁期24个月'>" +
        "45元/端/月，200万高清云台机 SD-IPC6001-WIR-F，租赁期24个月" +
        "</option>" +
        "<option value='50元/端/月，200万室外高清枪机 SD-IPC5081-IR-F，租赁期24个月'>" +
        "50元/端/月，200万室外高清枪机 SD-IPC5081-IR-F，租赁期24个月" +
        "</option>" +
        "<option value='90元/端/月，200万高清云台机（4G版）SD-IPC6001-IR-FGLE，租赁期24个月'>" +
        "90元/端/月，200万高清云台机（4G版）SD-IPC6001-IR-FGLE，租赁期24个月" +
        "</option>" +
        "<option value='100元/端/月，200万室外高清枪（4G版）SD-IPC5061-IR-FGLE，租赁期24个月'>" +
        "100元/端/月，200万室外高清枪（4G版）SD-IPC5061-IR-FGLE，租赁期24个月" +
        "</option>" +
        "</optgroup>";
}
function show_yun_dialogue() {
    productInfo +=
        "<optgroup label='功能费'>" +
        "<option value='单呼：30元/月/客户端，普通码号，含天翼对讲业务的全部功能、管理台自助管理功能'>" +
        "单呼：30元/月/客户端，普通码号，含天翼对讲业务的全部功能、管理台自助管理功能" +
        "</option>" +
        "<option value='临时组呼：10元/月/客户端，普通码号，含天翼对讲业务的全部功能、管理台自助管理功能'>" +
        "临时组呼：10元/月/客户端，普通码号，含天翼对讲业务的全部功能、管理台自助管理功能" +
        "</option>" +
        "<option value='预定义组呼：5元/月/客户端，普通码号，含天翼对讲业务的最基本功能'>" +
        "预定义组呼：5元/月/客户端，普通码号，含天翼对讲业务的最基本功能" +
        "</option>" +
        "<option value='遥毙/复活：8元/月/客户端，物联网码号，含天翼对讲业务的全部功能、管理台自助管理功能'>" +
        "遥毙/复活：8元/月/客户端，物联网码号，含天翼对讲业务的全部功能、管理台自助管理功能" +
        "</option>" +
        "</optgroup>";
}
function show_yun_newsletter() {
    productInfo +=
        "<optgroup label='功能费'>" +
        "<option value='翼讯通三网短信100元 含1200条普通国内三网短信'>" +
        "翼讯通三网短信100元 含1200条普通国内三网短信" +
        "</option>" +
        "<option value='翼讯通三网短信500元 含6300条普通国内三网短信'>" +
        "翼讯通三网短信500元 含6300条普通国内三网短信" +
        "</option>" +
        "<option value='翼讯通三网短信1000元 含14500条普通国内三网短信'>" +
        "翼讯通三网短信1000元 含14500条普通国内三网短信" +
        "</option>" +
        "<option value='' disabled>" +
        "订购当月开始功能费一次性收取，包含短信全部赠送，超出0.1元/条" +
        "</option>" +
        "<option value='' disabled>" +
        "翼讯通三网短信每条5分 每条价格0.05元 每月发送数量>100万条" +
        "</option>" +
        "<option value='' disabled>" +
        "翼讯通三网短信每条5分 每条价格0.05元 每月发送数量>100万条" +
        "</option>" +
        "<option value='' disabled>" +
        "翼讯通三网短信每条6分 每条价格0.06元  50万条<每月发送数量≤100万条" +
        "</option>" +
        "<option value='' disabled>" +
        "翼讯通三网短信每条7分 每条价格0.07元 30万条<每月发送数量≤50万条" +
        "</option>" +
        "<option value='' disabled>" +
        "翼讯通三网短信每条8分 每条价格0.08元 1万条<每月发送数量≤30万条" +
        "</option>" +
        "<option value='' disabled>" +
        "翼讯通三网短信每条1角 每条价格0.1元 每月发送数量<1万条" +
        "</option>" +
        "</optgroup>";
}
//云名片----
function show_yun_card_flashletter() {
    productInfo +=
        "<optgroup label='闪信功能费'>" +
        "<option value='9元/月 90次'>" +
        "9元/月 90次" +
        "</option>" +
        "<option value='29元/月 290次'>" +
        "29元/月 290次" +
        "</option>" +
        "<option value='100元/月 1000次 最多10个号码共享'>" +
        "100元/月 1000次 最多10个号码共享" +
        "</option>" +
        "<option value='300元/月 4000次 最多50个号码共享'>" +
        "300元/月 4000次 最多50个号码共享" +
        "</option>" +
        "<option value='600元/月 10000次 最多100个号码共享'>" +
        "600元/月 10000次 最多100个号码共享" +
        "</optgroup>";
}
function show_yun_card_MMS() {
    productInfo +=
        "<optgroup label='彩铃功能费'>" +
        "<option value='8元/户/月'>" +
        "8元/户/月" +
        "</option>" +
        "</optgroup>";
}
function show_yun_customer_assistant() {
    $("#yun_temp").html(q_CSMS);
    productInfo +=
        "<optgroup label='天翼号卡'>" +
        "<option value='月功能费28元'>" +
        "月功能费28元" +
        "</option>" +
        "</optgroup>"+
        "<optgroup label='云宽通'>" +
        "<option value='299 云网助手全功能、赠送20元短信包（含400条）'>" +
        "299 云网助手全功能、赠送20元短信包（含400条）" +
        "</option>" +
        "<option value='599 云网助手全功能、赠送50元短信包（含1000条）'>" +
        "599 云网助手全功能、赠送50元短信包（含1000条）" +
        "</option>" +
        "<option value='999 云网助手全功能、赠送50元短信包（含1000条）'>" +
        "999 云网助手全功能、赠送50元短信包（含1000条）" +
        "</option>" +
        "<option value='1299 云网助手全功能、赠送50元短信包（含1000条）'>" +
        "1299 云网助手全功能、赠送50元短信包（含1000条）" +
        "</option>" +
        "<option value='2899 云网助手全功能、赠送50元短信包（含1000条）'>" +
        "2899 云网助手全功能、赠送50元短信包（含1000条）" +
        "</option>" +
        "</optgroup>";
}
function show_yun_housekeeper() {
    productInfo +=
        "<optgroup label='备份客户端功能费'>" +
        "<option value='20元/月/客户端'>" +
        "20元/月/客户端" +
        "</option>" +
        "</optgroup>"+
        "<optgroup label='备份客户端功能费'>" +
        "<option value='50元/月/100GB'>" +
        "50元/月/100GB" +
        "</option>" +
        "</optgroup>";
}



