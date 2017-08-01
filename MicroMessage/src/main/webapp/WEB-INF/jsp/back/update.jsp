<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>指令添加页面</title>
		<link href="resources/css/insert.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="resources/js/common/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="resources/js/back/list.js"></script>
</head>
<body >
	<form action="insert.action" id="mainForm" method="post">
		<table>
			<caption><strong>修改指令</strong></caption>
			<tr>
				<td >指令：</td>
				<td ><input type = "text" name="name" placeholder="请输入指令" value="${requestScope.commod.name }"></td>
			</tr>
			<tr>
				<td >描述：</td>
				<td ><input type = "text" name="descript" placeholder="请输入指令描述" value="${requestScope.commod.descript }" ></td>
			</tr>
			<c:choose>
				<c:when test="${empty requestScope.commod.contextList}">
					<tr>
						<td >内容:</td>
						<td ><textarea  name="context" placeholder="请输入指令内容" >还没有添加内容</textarea></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.commod.contextList}" var="item" varStatus="status">
						<tr>
							<td >内容${status.index + 1}:</td>
							<td ><textarea  name="context" placeholder="请输入指令内容" >${item.context }</textarea></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td><input type = "button" id="update" onclick="UpdateOne(${requestScope.commod.id })" value = "修改"></td>
				<td><input type = "button" id="insertContext" onclick="LinkInsertContext(${requestScope.commod.id })" value = "新增内容"></td>
			</tr>
		</table>
	</form>
</body>
</html>