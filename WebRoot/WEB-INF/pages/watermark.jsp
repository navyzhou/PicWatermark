<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>水印</title>
<style type="text/css">
	img{
		width:200px;
		height:200px;
		margin-left:50px;
	}
</style>
</head>
<body>
	<center>
	<s:iterator value="picInfos">
		<img src='${pageContext.request.contextPath }<s:property value="picPath"/>'/>
		<img src='${pageContext.request.contextPath }<s:property value="markTextPath"/>'/>
		<img src='${pageContext.request.contextPath }<s:property value="markImagePath"/>'/>
		<img src='${pageContext.request.contextPath }<s:property value="markTextMorePath"/>'/>
		<img src='${pageContext.request.contextPath }<s:property value="markImageMorePath"/>'/>
		<br/>
	</s:iterator>
	</center>
</body>
</html>