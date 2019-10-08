<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
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
								<TD class=manageHead>当前位置：借阅信息管理 &gt; 借阅列表</TD>
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
									<FORM id="pageForm" name="borrowForm"
										action="${pageContext.request.contextPath }/BorrowAction_list"
										method=post>
										<!-- 隐藏域.当前页码 -->
										<input type="hidden" name="currentPage" id="currentPageInput" value="<s:property value="#pageBean.currentPage" />" />
										<!-- 隐藏域.每页显示条数 -->
										<input type="hidden" name="pageSize" id="pageSizeInput"       value="<s:property value="#pageBean.pageSize" />" />
									</FORM>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>书编号</TD>
													<TD>书封面</TD>
													<TD>书名</TD>
													<TD>学号</TD>
													<TD>姓名</TD>
													<TD>借书日期</TD>
													<TD>还书日期</TD>
													<TD>超期罚款</TD>
													<TD>距到期天数</TD>
												</TR>
												<s:iterator value="#pageBean.list" var="borrow" >
												<TR 		
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>
														<s:property value="#borrow.book.book_num" />
													</TD>
													<TD>
														<img alt="" src="${pageContext.request.contextPath }/images/${borrow.book.book_image}" width="50px" height="50px">
													</TD>
													<TD>
														<s:property value="#borrow.book.book_name" />
													</TD>
													<TD>
														<s:property value="#borrow.student.stu_num" />
													</TD>
													<TD>
														<s:property value="#borrow.student.stu_name" />
													</TD>
													<TD>
													<s:property value="#borrow.borrow_time" />
													</TD>
													<TD>
													<s:property value="#borrow.return_time" />
													</TD>
													<TD>
													<s:property value="#borrow.ticket" />
													</TD>
													<TD>
													<s:property value="#borrow.exprie" />
													</TD>
												</TR>
												</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
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
