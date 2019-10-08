<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<SCRIPT language=javascript>
	function changePage(pageNum){
			//1 将页码的值放入对应表单隐藏域中
				$("#currentPageInput").val(pageNum);
			//2 提交表单
				$("#pageForm").submit();
	};
	
	function changePageSize(pageSize){
			//1 将页码的值放入对应表单隐藏域中
			$("#pageSizeInput").val(pageSize);
		//2 提交表单
			$("#pageForm").submit();
	};
</SCRIPT>
<style type="text/css">
	#BookDiv{
		float: left;
		width: 220px;
		height: 250px;
		border: 2px solid gray;
		word-wrap:break-word;
		margin-right: 60px;
		margin-bottom: 20px;
	}
</style>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
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
								<TD class=manageHead>当前位置：图书管理 &gt; 图书列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
									<FORM id="pageForm" name="bookForm"
										action="${pageContext.request.contextPath }/StudentUIAction_list"
										method=post>
										<!-- 隐藏域.当前页码 -->
										<input type="hidden" name="currentPage" id="currentPageInput" value="<s:property value="#pageBean.currentPage" />" />
										<!-- 隐藏域.每页显示条数 -->
										<input type="hidden" name="pageSize" id="pageSizeInput"       value="<s:property value="#pageBean.pageSize" />" />
										
									</FORM>
									</TD>
								</TR>
								<tr>
									<s:iterator value="#pageBean.list" var="book" >
										<div id="BookDiv">
											<img alt="" src="${pageContext.request.contextPath }/images/${book.book_image}" width="150px" height="150px"><br>
											书名：<s:property value="#book.book_name" /><br>
											作者：<s:property value="#book.writer" /><br>
											出版社：<s:property value="#book.pubcompany" /><br>
											借阅情况：<s:property value="#book.giveback" /><br>
										</div>
									</s:iterator>
								</tr>
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B><s:property value="#pageBean.totalCount" /> </B>]条记录,[<B><s:property value="#pageBean.totalPage" /></B>]页
												,每页显示 <%-- changePageSize($('#pageSizeSelect option').filter(':selected').val()) --%> 
												<select name="pageSize" onchange="changePageSize($('#pageSizeSelect option:selected').val())" id="pageSizeSelect" >
													<option value="9" <s:property value="#pageBean.pageSize==9?'selected':''" /> >9</option>
												</select>
												条
												[<A href="javaScript:void(0)" onclick="changePage(<s:property value='#pageBean.currentPage-1' />)" >前一页</A>]
												<B><s:property value="#pageBean.currentPage" /></B>
												[<A href="javaScript:void(0)" onclick="changePage(<s:property value='#pageBean.currentPage+1' />)"  >后一页</A>] 
												到
												<input type="text" size="9" id="page" name="page" value="<s:property value="#pageBean.currentPage" />"  />
												页
												
												<input type="button" value="Go" onclick="changePage($('#page').val())"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
	
</BODY>
</HTML>
