<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript">
window.onload = function(){
	//获得当前回显的product的cid
	var cid = "${bookEditUI.category.category_num }";
	//获得所有的<select name="cid">下的option
	var options = document.getElementById("cid").getElementsByTagName("option");
	//比较每一个option的value与cid
	for(var i=0;i<options.length;i++){
		if(cid==options[i].value){
			options[i].selected = true;
		}
	}
}
</script>

<script type="text/javascript">
	function changeImage(){
		var str = document.getElementById("fileId").value;
		var arr = str.split("\\");
		var bookImage = document.getElementById("bookImage");
		bookImage.setAttribute("src", "${pageContext.request.contextPath }/images/"+arr[arr.length - 1]);
		document.getElementById("hidden").value = arr[arr.length - 1];
	}
</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/BookAction_update"
		method=post>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：图书管理 &gt; 修改图书</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>图书编号：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="book_num" value="${bookEditUI.book_num }">
								</td>
								<td>封面：</td>
								<td>
									<img alt="" src="${pageContext.request.contextPath }/images/${bookEditUI.book_image}" width="50px" height="50px" id="bookImage">
									<input type="file" style="WIDTH: 180px" maxlength="50" onchange="changeImage()" id="fileId">
									<input type="hidden" id="hidden" name="book_image" value="${bookEditUI.book_image}">
								</td>
							</TR>
							
							<TR>
								<td>书名：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="book_name" value="${bookEditUI.book_name }">
								</td>
								<td>作者：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="writer" value="${bookEditUI.writer }">
								</td>
							</TR>
							<TR>
								<td>单价：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="price" value="${bookEditUI.price }">
								</td>
								<td>出版社：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="pubcompany" value="${bookEditUI.pubcompany }">
								</td>
							</TR>
							<TR>
								<td>上架日期：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="buydate" value="${bookEditUI.buydate }">
								</td>
								<td>出版日期：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="pubdate" value="${bookEditUI.pubdate }">
								</td>
							</TR>
							<TR>
								<td>类型：</td>
								<td>
									<select name="category.category_num" id="cid">
										<c:forEach items="${categoryList }" var="category">
											<option value="${category.category_num}">${category.category_name }</option>
										</c:forEach>
									</select>
								</td>
								<td>借阅情况：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="giveback" value="${bookEditUI.giveback }">
								</td>
							</TR>
							
						</TABLE>
						<input type="hidden" name="book_id" value="${bookEditUI.book_id }">
						<input type="submit" value="修改完成">
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		
	</FORM>
</BODY>
</HTML>
