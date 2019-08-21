var canGetCookie = 0;//是否支持存储Cookie 0 不支持 1 支持
var ajaxmockjax = 0;//是否启用虚拟Ajax的请求响 0 不启用  1 启用
//默认账号密码

var truelogin = "kbcxy";
var truepwd = "mcwjs";

var CodeVal = 0;
Code();
function Code() {
    if(canGetCookie == 1){
        createCode("AdminCode");
        var AdminCode = getCookieValue("AdminCode");
        showCheck(AdminCode);
    }else{
        showCheck(createCode(""));
    }
}
function showCheck(a) {
    CodeVal = a;
  
}
$(document).keypress(function (e) {
    // 回车键事件  
    if (e.which == 13) {
        $('input[type="button"]').click();
    }
});
//粒子背景特效
$('body').particleground({
    dotColor: '#E8DFE8',
    lineColor: '#133b88'
});
$('input[name="pwd"]').focus(function () {
    $(this).attr('type', 'password');
});
$('input[type="text"]').focus(function () {
    $(this).prev().animate({ 'opacity': '1' }, 200);
});
$('input[type="text"],input[type="password"]').blur(function () {
    $(this).prev().animate({ 'opacity': '.5' }, 200);
});
$('input[name="login"],input[name="pwd"]').keyup(function () {
    var Len = $(this).val().length;
    if (!$(this).val() == '' && Len >= 5) {
        $(this).next().animate({
            'opacity': '1',
            'right': '30'
        }, 200);
    } else {
        $(this).next().animate({
            'opacity': '0',
            'right': '20'
        }, 200);
    }
});
var open = 0;
layui.use('layer', function () {
    /*var msgalert = '默认账号:' + truelogin + '<br/> 默认密码:' + truepwd;
    var index = layer.alert(msgalert, { icon: 6, time: 4000, offset: 't', closeBtn: 0, title: '友情提示', btn: [], anim: 2, shade: 0 });  
    layer.style(index, {
        color: '#777'
    });*/ 
    //非空验证
    $('input[type="button"]').click(function () {
        var login = $('input[name="login"]').val();
        var pwd = $('input[name="pwd"]').val();
        var code = $('input[name="code"]').val();
        var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
        if (login == '') {
            ErroAlert('请输入您的账号');
        } else if (pwd == '') {
            ErroAlert('请输入密码');
        } else if (code == '' || !reg.test(code)) {
            ErroAlert('输入正确邮箱号');
        } else {
            //认证中..
            fullscreen();
            $('.login').addClass('test'); //倾斜特效
            setTimeout(function () {
                $('.login').addClass('testtwo'); //平移特效
            }, 300);
            setTimeout(function () {
                $('.authent').show().animate({ right: -320 }, {
                    easing: 'easeOutQuint',
                    duration: 600,
                    queue: false
                });
                $('.authent').animate({ opacity: 1 }, {
                    duration: 200,
                    queue: false
                }).addClass('visible');
            }, 500);

            //登陆
            var JsonData = { login: login, pwd: pwd, code: code };
            //此处做为ajax内部判断
            var url = "";
            if(true){
                url = "Registeraction";
                $.ajax({
                type: "post",
                url: url,
                data: JsonData,
                dataType: 'json',
                async: 'false',
        
                error: function (error) { 
                console.log("失败");
                    console.log(error);
                },
                success: function(data) {
                        
                        setTimeout(function () 
                                {
                                    $('.authent').show().animate({ right: 90 }, 
                                        {
                                            easing: 'easeOutQuint',
                                            duration: 600,
                                            queue: false
                                           }
                                       );
                                    $('.authent').animate({ opacity: 0 }, 
                                        {
                                            duration: 200,
                                            queue: false
                                        }
                                    ).addClass('visible');
                                    $('.login').removeClass('testtwo'); //平移特效
                                }, 2000);
                                setTimeout(function () 
                                {
                                    $('.authent').hide();
                                    $('.login').removeClass('test');
                                 
                                    if (data.responseText.Status == 'ok') 
                                    {
                                        //登录成功
                                        $('.login div').fadeOut(100);
                                        $('.success').fadeIn(1000);
                                        $('.success').html(data.responseText.Text);
                                        //跳转操作
                                        setTimeout(function(){
                                            window.location.href = "login.jsp";
                                        },1000);
                                         
                                    } else {
                                        AjaxErro(data);
                                    }
                                }, 2400);
                }
            });
            }else{
                layer.msg("注册失败！");
                setTimeout(function(){
                    window.location.href = "register.jsp" ;
                },1000);	
            }

        }
    })
})
var fullscreen = function () {
    elem = document.body;
    if (elem.webkitRequestFullScreen) {
        elem.webkitRequestFullScreen();
    } else if (elem.mozRequestFullScreen) {
        elem.mozRequestFullScreen();
    } else if (elem.requestFullScreen) {
        elem.requestFullscreen();
    } else {
        //浏览器不支持全屏API或已被禁用  
    }
}  
/*if(ajaxmockjax == 1){
    $.mockjax({  
        url: 'Ajax/Login',  
        status: 200,  
        responseTime: 50,          
        responseText: {"Status":"ok","Text":"登陆成功<br /><br />欢迎回来"}  
    }); 
    $.mockjax({  
        url: 'Ajax/LoginFalse',  
        status: 200,  
        responseTime: 50,          
        responseText: {"Status":"Erro","Erro":"账号名或密码或验证码有误"}
    });   
}*/