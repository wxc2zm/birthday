<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>客户管理</title>
    <script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>
        <script type="text/javascript">
    var vResult = false;
    	//校验手机号唯一
    	function doVerify(){
    		//1、获取手机号
    		var mobile = $("#mobile").val();
    		if(mobile != ""){
    			//2、校验 
    			$.ajax({
    				url:"${basePath}xfgl/user_verifyMobile.action",
    				data: {"user.mobile": mobile},
    				type: "post",
    				async: false,//非异步
    				success: function(msg){
    					if("true" != msg){
    						//帐号已经存在
    						alert("此手机号已存在");
    						//定焦
    						$("#mobile").focus();
    						vResult = false;
    					} else {
    						vResult = true;
    					}
    				}
    			});
    		}
    	}
    	//提交表单
    	function doSubmit(){
    		var name = $("#name");
    		if(name.val() == ""){
    			alert("姓名不能为空！");
    			name.focus();
    			return false;
    		}
    		var mobile = $("#mobile");
    		if(mobile.val() == ""){
    			alert("手机号不能为空！");
    			mobile.focus();
    			return false;
    		}
    		var birthday = $("#birthday");
    		if(birthday.val() == ""){
    			alert("生日不能为空！");
    			birthday.focus();
    			return false;
    		}
    		
    		//判断更改后的手机号是否与原手机号相同，不同进行校验
    		if(!(${user.mobile} == $("#mobile").val())) {
    			//帐号校验
    			doVerify();
    			if(vResult){
	    			//提交表单
	    			document.forms[0].submit();
    			}
    		} else {
    			//提交表单
    			document.forms[0].submit();
    		}

    		
    	}
    </script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }xfgl/user_edit.action" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>客户管理</strong>&nbsp;-&nbsp;编辑客户</div></div>
    <div class="tableH2">编辑客户</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">姓名：</td>
            <td><s:textfield id="name" name="user.name"/> </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td><s:radio list="#{'true':'男','false':'女'}" name="user.gender"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">手机号：</td>
            <td><s:textfield id="mobile" name="user.mobile"/></td>
        </tr>        
        <tr>
            <td class="tdBg" width="200px">生日：</td>
            <td>
            <s:textfield id="birthday" name="user.birthday" readonly="true" 
            onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});" >
            	<s:param name="value"><s:date name="user.birthday" format="yyyy-MM-dd"/></s:param>
            </s:textfield>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">地址：</td>
            <td><s:textfield id="address" name="user.address"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td><s:textarea name="user.memo" cols="75" rows="3"/></td>
        </tr>
    </table>
    <s:hidden name="user.id"/>
    <div class="tc mt20">
        <input type="button" class="btnB2" value="保存" onclick="doSubmit()" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>