<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>图片水印</title>
  </head>
  
  <body>
		<form action="watermark" enctype="multipart/form-data" method="post" >  
			上传文件：<input type="file" name="file"><br/>
			上传文件： <input type="file" name="file"><br/>
			<input type="submit" value="提交"/>  
     </form>  
  </body>
</html>
