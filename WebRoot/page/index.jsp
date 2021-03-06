<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	byte[] byteRand = new byte[32];
	new java.util.Random().nextBytes(byteRand);
	String random = new sun.misc.BASE64Encoder().encode(byteRand);
	
	HttpSession sess = request.getSession();
	if (sess == null){
		sess = request.getSession(true);
	}	
	sess.setAttribute("auth.random",random);
	System.out.println("login flag:" + random);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>PMS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="pms, a user privilege authentication admin console.">
	<meta name="author" content="ilbcj">
	<meta http-equiv="content-language" content="zh_CN" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <!-- The styles -->
    <link rel="stylesheet" type="text/css" href="<%=path %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/main.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/datagrid-detailview.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.json.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/main.js"></script>
	
	<script type="text/javascript" src="<%=path %>/js/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
    <script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
</head>

<body class="easyui-layout" style="background:#E6EEF8;">
<div data-options="region:'north',split:false,noheader:true,border:false" style="height:73px;background: url(../images/header_01.gif) repeat-x;">
	<img src="../images/header_02.gif" />
</div><!-- end of north -->
<!--     <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div> -->
<!--     <div data-options="region:'east',title:'East',split:true" style="width:100px;"></div> -->
<div data-options="region:'west',split:true,noheader:true,border:false" style="width:200px;">
	<div id="mm" class="easyui-accordion"  fit="true">
	</div>
</div><!-- end of west -->
    <div data-options="region:'center',noheader:true, border:true" style="padding:5px;background:#E6EEF8;"></div>

<script>
$(document).keydown(function(e){
// 	if ((event.keyCode==8) ) //屏蔽退格删除键    
// 	{     
// 	    if (window.event.srcElement.tagName.toUpperCase()!="INPUT" && 
// 	    		window.event.srcElement.tagName.toUpperCase()!="TEXTAREA" && 
// 	    		window.event.srcElement.tagName.toUpperCase()!="TEXT")
// 	    {    
// 			event.keyCode=0;     
// 			event.returnValue=false;    
// 		}     
// 	}     
	var doPrevent; 
	if (e.keyCode == 8) { 
		var d = e.srcElement || e.target; 
		if (d.tagName.toUpperCase() == 'INPUT' || d.tagName.toUpperCase() == 'TEXTAREA' || d.tagName.toUpperCase() == 'TEXT') 
		{ 
			doPrevent = d.readOnly || d.disabled; 
		} 
		else 
			doPrevent = true; 
	} 
	else 
		doPrevent = false; 

	if (doPrevent) e.preventDefault();   
});
$(document).ready(function () {
	var poststr1 = "admin.loginid=" + '${sessionScope.admin}';
	$.post("../admin/queryAdminByLoginid.action?rand=" + Math.random(), poststr1, function(retObj) {	
		if(retObj.result == true)
		{	
			var poststr2 = "admin.id=" + retObj.admin.id;
			$.post("../admin/queryAdminAccreditById.action?rand=" + Math.random(), poststr2, function(retObj) {
				if(retObj.result == true)
				{
		    		for(var index=0; index < retObj.accredits.length; index++ ) {
		    			if(retObj.accredits[index].pid == 0){
			    			$('#mm').accordion('add', {
								title: '机构管理',
								href:'menu/organization.html',
								selected: false
							});
		    			}
		    			if(retObj.accredits[index].pid == 1){
			    			$('#mm').accordion('add', {
								title: '用户管理',
								href:'menu/user.html',
								selected: false
							});
		    			}
		    			if(retObj.accredits[index].pid == 2){
							$('#mm').accordion('add', {
								title: '群体管理',
								href:'menu/group.html',
								selected: false
							});
		    			}
		    			if(retObj.accredits[index].pid == 3){
							$('#mm').accordion('add', {
								title: '角色管理',
								href:'menu/role.html',
								selected: false
							});
		    			}
		    			if(retObj.accredits[index].pid == 4){
							$('#mm').accordion('add', {
								title: '资源管理',
								href:'menu/resource.html',
								selected: false
							});
		    			}
		    			if(retObj.accredits[index].pid == 5){
							$('#mm').accordion('add', {
								title: '授权管理',
								href:'menu/privilege.html',
								selected: false
							});
		    			}
		    			if(retObj.accredits[index].pid == 6){
							$('#mm').accordion('add', {
								title: '系统管理',
								href:'menu/system.html',
								selected: false
							});
		    			}
		    			if(retObj.accredits[index].pid == 7){
							$('#mm').accordion('add', {
								title: '日志审计',
								href:'menu/log.html',
								selected: false
							});
		    			}
		    			if(retObj.accredits[index].pid == 8){
							$('#mm').accordion('add', {
								title: '管理员管理',
								href:'menu/admin.html',
								selected: false
							});
		    			}
		    		}
				}
				else
				{
					warningTip("提示", '获取管理员权限操作对象失败');	
					refreshDetailPage();
					return;
				}
			}, "json");
		}
		else
		{
			warningTip("提示", '获取管理员信息失败');	
			refreshDetailPage();
			return;
		}
	}, "json");
	
// 	$('#mm').accordion('add', {
// 		title: '机构管理',
// 		href:'menu/organization.html',
// 		selected: false
// 	});
	
// 	$('#mm').accordion('add', {
// 		title: '用户管理',
// 		href:'menu/user.html',
// 		selected: false
// 	});

// 	$('#mm').accordion('add', {
// 		title: '账号管理',
// 		href:'menu/account.html',
// 		selected: false
// 	});
// 	$('#mm').accordion('add', {
// 		title: '群体管理',
// 		href:'menu/group.html',
// 		selected: false
// 	});
	
// 	$('#mm').accordion('add', {
// 		title: '角色管理',
// 		href:'menu/role.html',
// 		selected: false
// 	});
	
// 	$('#mm').accordion('add', {
// 		title: '资源管理',
// 		href:'menu/resource.html',
// 		selected: false
// 	});
	
// 	$('#mm').accordion('add', {
// 		title: '授权管理',
// 		href:'menu/privilege.html',
// 		selected: false
// 	});

// 	$('#mm').accordion('add', {
// 		title: '系统管理',
// 		href:'menu/system.html',
// 		selected: false
// 	});
	
// 	$('#mm').accordion('add', {
// 		title: '日志审计',
// 		href:'menu/log.html',
// 		selected: false
// 	});
	
// 	$('#mm').accordion('add', {
// 		title: '管理员管理',
// 		href:'menu/admin.html',
// 		selected: false
// 	});
	
	$('#mm').accordion('select', 4);

});

</script>
</body>
</html>
