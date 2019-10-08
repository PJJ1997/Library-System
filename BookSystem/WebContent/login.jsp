<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的“书屋”</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-select.css" />

<style type="text/css">

.bgImg {
	position: absolute;
	top: 0px;
	left: 0px;
	bottom: 0px;
	right: 0px;
	width: 100%;
	height: 100%;
}


body .content {
	width: 42%;
	position: fixed;
	border-radius: 5px;
	border: 2px solid black;
	left: 300px;
	top:40px;
}
</style>
</head>
<body>
<img src="images/bgImg.png" class="bgImg" />
<form action="Login" method="post">
	<div class="content" align="center">
		<h1>图书馆管理系统登录</h1><br>
		<table>
			<tr>
				<td>账号：</td>
				<td><input type="text" name="number"/></td>
			</tr>
			<tr>
				<td>角色：</td>
				<td>
					<select name="role">
			            <option value="1">学生</option>
			            <option value="2">管理员</option>
			        </select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<span style="color: red">
						<c:if test="${sessionScope.flag == '1' }">
							${sessionScope.error }
						</c:if>
					</span>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="登  录"> </td>
				<td><input type="reset" value="重  置"></td>
			</tr>
		</table>
	</div>	
</form>
</body>
</html>