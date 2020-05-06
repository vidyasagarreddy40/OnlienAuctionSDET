<%@page import="com.sdet.training.dao.productsDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Winner !</title>
</head>
<body>
	<%
		productsDao dao = new productsDao();
		String maxBid = dao.getMaxBid();
	%>


	<table border="1">

		<tr>
			<td style="width: 700px" id="winner"><%=maxBid%></td>
		</tr>

		<tr></tr>
		<tr>
			<td>
				<div>
					<form action="<%=request.getContextPath()%>/winnerServlet"
						method="post">

						<table>
							<tr>
								<td>
								<td><input id="closebtn" type="submit" value="Close Bid" /></td>

							</tr>
						</table>

					</form>
				</div>
	</table>


</body>
</html>