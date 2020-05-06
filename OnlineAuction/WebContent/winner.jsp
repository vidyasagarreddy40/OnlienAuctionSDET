<%@page import="com.sdet.training.dao.productsDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
			productsDao dao=new productsDao();
			String maxBid = dao.getMaxBid();
		%>


	<table border="1">

		<tr>
			
			<td style="width: 700px" id="winner"><%=maxBid%></td>
		</tr>
	</table>


</body>
</html>