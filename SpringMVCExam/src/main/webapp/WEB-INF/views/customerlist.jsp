<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html>
<head>

	
	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/menu.js"></script>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery-3.1.0.min.js"></script>
<link href="<%=request.getContextPath()%>/Css/customer.css" type="text/css" rel="stylesheet">

<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<script type="text/javascript">
function getValue(val){
	var a=val;
	if(confirm("确定删除？")){
		$(document).ready(function(){
			$.ajax({
	            type:"POST",
	            url:"deletecustomer",
	            data:"customer_id="+a,
	            success:function(){
	        		var bu=$("#delete"+a).val();
	        		$("tr").remove("#"+bu);
	            }
	        });
			});
	}
	else{
		return false;
	}
	}
	
	

function Customerslist(pagenum){

	$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"testajax",
		data:"pagenum="+pagenum,
		dataType:"json",
		cache: false,//不缓存 
		error:function(){
			alert("失败");
		},
		success:function(data){
			var doc="<tr><th style='width:5%;'>修改</th><th style='width:5%;'>删除</th><th style='width:15%;'>First Name</th><th style='width:15%;'>Last Name</th><th style='width:20%;'>Address</th>" +
			"<th style='width:30%;'>Email</th><th>Customerid</th><th style='width:10%;'>Last Update</th></tr>";
			for(var i=0;i<data.customers.length;i++){
				doc+="<tr id='"+data.customers[i].customer_id+"'><td><form action='updatecustomer' method='post'><input type='hidden' value='"+data.customers[i].customer_id+"' name='customer_id'> <input type='submit' value='修改'></form></td><td><button id='delete"+data.customers[i].customer_id+"' value='"+data.customers[i].customer_id+"'onClick='getValue("+data.customers[i].customer_id+")'>删除</button></td></br>"+
				"<td>"+data.customers[i].first_name+"</td></br>" +
				"<td>"+data.customers[i].last_name+"</td></br>" +
				"<td>"+data.customers[i].address.address+"</td></br>" +
				"<td>"+data.customers[i].email+"</td></br>" +
				"<td>"+data.customers[i].customer_id+"</td></br>" +
				"<td>"+data.customers[i].last_update+"</td></tr>";
				}

				$("#Customerlist").html(doc);
		}
	});	
	});
}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>customerlist</title>
</head>

<body onload="Customerslist(1)">
	<div id="Container">
		<div id="Header">
			<div id="logo">10478 刘婉婉
			<div id="user" class="glyphicon glyphicon-user"><a href="logout">退出</a></div>
			</div>
		</div>
		<div id="Content">
			<div id="Content-Left">
				<div id="nav">
					<h3>顾客</h3>
					<div>
						<a href="#">查詢</a> <a href="#">增加</a> <a href="#">刪除</a>
					</div>
					<h3>影片</h3>
					<div>
					<a href="#">JavaScript</a> <a href="#">Delphi</a> <a href="#">VC++</a>
					</div>
				</div>
			</div>
			<div id="Content-Main">
				<div id="add">
				客户列表 <a href="addcustomer">新建</a>
				</div>
				<div id="list">
					<table id="Customerlist">
					</table>
				</div>
				<div id="page">
					共${requestScope.count }条记录,分${requestScope.countpage }页 <br>
					 <a href="#" onclick="Customerslist(1)">首页</a> 

						<c:forEach var="i" begin="1" end="${requestScope.countpage }">

							<a href="#" onclick="Customerslist(${i})">${i}</a>
						</c:forEach>
						<a href="#" onclick="Customerslist(${requestScope.countpage})">尾页</a>
				</div>
			</div>
		</div>
		<div class="Clear">
			<!--如何你上面用到float,下面布局开始前最好清除一下。-->
		</div>
		<div id="Footer"></div>
	</div>
</body>
</html>