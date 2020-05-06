<%@page import="com.sdet.training.dao.productsDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bid it here!</title>
<%
	productsDao dao = new productsDao();
	String prod = dao.getProduct();
%>
<style>
.vl {
	border-left: 6px solid green;
	height: 500px;
	position: absolute;
	left: 50%;
	margin-left: -3px;
	top: 0;
}
</style>

<script type="text/javascript">
	function showAlert() {
		alert("Bid is created");
	}

	function validate() {
		var name = document.myform.userName.value;
		if (name == "") {
			alert("Please enter the Name");
			document.myform.userName.foucs;
			return false;
		}

		var email = document.myform.email.value;
		if (email == "") {
			alert("Please enter the email");
			document.myform.email.foucs;
			return false;
		}

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
</head>
<body onload="disabled()">

	<div align="right" style="background-color: #00CED1; color: #000000;">
		<a href="login.jsp">back to Home Page</a>
	</div>
	<!-- <table style="background-color: #006969; color: #FAEBD7;">
		<tr>
			<td><label>Products are not available</label></td>
		</tr>
	</table> -->
	<div class="vl"></div>
	<table id="prodtb" border="1">
		<tr>
			<td id="productname"><%=prod%></td>
			<td><input id="adcart" type="button" value="Add to Cart"
				onClick="showHideDiv('divMsg')" /></td>
		</tr>
	</table>
	<div id="divMsg"
		style="background-color: #006969; color: #ffffff; height: 185px; width: 250px; text-align: center; display: none">
		<form name="myform"
			action="<%=request.getContextPath()%>/bidderServlet" method="post">
			<table border="1">
				<tr>
					<td>Name:</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Bid Amount:</td>
					<td><input type="text" name="amount"></td>
				</tr>
				<tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input type="text" name="phoneNumber"></td>
				</tr>

				<tr>
					<td>Address:</td>
					<td><input type="text" name="address"></td>
				</tr>
			</table>
			<input id="Bidid" type="submit" value="Bid"
				onclick="return validate();" />

		</form>

	</div>
</body>
</html>