<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<link href="<%= request.getContextPath() %>/Css/background.css" type="text/css" rel="stylesheet">
<link href="<%= request.getContextPath() %>/Css/login.css" type="text/css" rel="stylesheet">
</head>
<script type="text/javascript">

 function validate_required(field,alerttxt)
{
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false}
  else {return true}
  }
}


	function validate_form(thisform) {
		with (thisform) {
			if (validate_required(first_name, "用户名不能为空!") == false) {
				first_name.focus();
				return false;
			}
		if (validate_required(password, "密码不能为空!") == false) {
			password.focus();
			return false;
		}
		}
	} 
</script>
<body>
<div id="body">
<div id="id">10478 刘婉婉</div>
<div id="bodylogin">

	<div id="top">电影租赁管理系统</div>
		<form action="login" id="login" method="post">
		<table id="login">
		<tr>
		<td>用户名：</td>
		<td><input type="text" name="first_name" id="username_id" class="input_class"><div id="username_message"></div></td>
		</tr>
		<tr>
		<td>密码：</td>
		<td><input type="password" name="password" id="password_id" class="input_class"><div id="password_message"></div></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="登陆" id="submit_id" onclick="return validate_form(this.form)"> </td>
		</tr>
		</table>
		</form>
		</div>
		</div>
</body>
</html>
