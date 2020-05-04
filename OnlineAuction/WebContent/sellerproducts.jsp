<%@page import="java.util.List"%>
<%@page import="com.sdet.training.dao.productsDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell it here!</title>
</head>

<script type="text/javascript">

    function updateProductStatus(){
    	
    	var myClass= Java.type("com.sdet.training.dao.productsDao");
    	myClass.getMaxBid();
    }

	function showHideDiv(ele) {
		var srcElement = document.getElementById(ele);
		if (srcElement != null) {
			if (srcElement.style.display == "block") {
				srcElement.style.display = 'none';
			} else {
				srcElement.style.display = 'block';
			}
			return false;
		}
	}
</script>
<body>

	<div align="right" style="background-color: #00CED1; color: #vffcff;">
		<a href="login.jsp">back to Home Page</a>
	</div>

	<div>

		<%
			productsDao dao = new productsDao();
			String prod = dao.getProduct();
			
			String maxBid=dao.getMaxBid();
			
		
		%>


		<table border="1">
			<tr>
				<td><label>Product Name</label></td>
				<td><%=prod%></td>
			</tr>
			<tr>
				<td><input type="button" value="Create Product"
					onClick="showHideDiv('divCreate')" /></td>
				<td><input type="button" value="Get Details"
					onClick="showHideDiv('divDetails')" /></td>
			</tr>
		</table>
	</div>
	<div id="divCreate"
		style="background-color: #006969; color: #ffffff; height: 105px; width: 225px; text-align: center; display: none">
		<form action="<%=request.getContextPath()%>/productServlet"
			method="post">
			<table style="with: 80%">
				<tr>
					<td>Product Name</td>
					<td><input type="text" name="productName" /></td>
				</tr>
				<tr>
					<td>Model</td>
					<td><input type="text" name="model" /></td>
				</tr>

			</table>
			<input type="submit" value="Create" />
		</form>
	</div>

	<div id="divDetails"
		style="background-color: #006969; color: #ffffff; height: 400px; width: 550px; text-align: center; display: none">
		<form action="<%=request.getContextPath()%>/productServlet"
			method="post">
			<table align="center" cellspacing="10" border="1">
				<tr>
					<td></td>
					<td><strong>Name</strong></td>
					<td><strong>Bid Amount</strong></td>
					<td><strong>Email</strong></td>
					<td><strong>Phone</strong></td>

				</tr>

				<%-- 	<input type="hidden" name="id" value="<%=id%>" />
				<input type="hidden" name="name" value="<%=name%>" /> --%>
				<%! int i; %>
					<%for ( i = 0; i < 3; i++){ %>
					
					<tr>
					<td></td>
					<td><%=dao.getbidders().get(i).getUserName()%></td>
					<td><%=dao.getbidders().get(i).getAmount()%></td>
					<td><%=dao.getbidders().get(i).getEmail()%></td>
					<td><%=dao.getbidders().get(i).getPhoneNumber()%></td></tr>
					<%}%>
			</table>

		</form>
		<tr>
			<td>
			<td><input type="button" value="Confirm" onClick="updateProductStatus()" /></td>
			<td><%=maxBid%></td>
			
		</tr>
		
	</div>
</body>
</html>