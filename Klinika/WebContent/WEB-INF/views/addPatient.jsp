<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add patient</h2>
	<form:form method="POST" action="save.html">
		<table>
			<tr>
				<td><form:label path="idpatient">Patient ID:</form:label></td>
				<td><form:input path="idpatient" value="${patient.idpatient}"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Patient Name:</form:label></td>
				<td><form:input path="name" value="${patient.name}" /></td>
			</tr>
			<tr>	
				<td><form:label path="birthday">Patient Birthday:</form:label></td>
				<td></td>
			</tr>
	
			<tr>
				<td><form:label path="country">Patient Country:</form:label></td>
				<td><form:input path="country" value="${patient.country}" /></td>
			</tr>

			<tr>
				<td><form:label path="email">Patient email:</form:label></td>
				<td><form:input path="email" value="${patient.email}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty patients}">
		<h2>Patients List</h2>
		<table align="left" border="1">
			<tr>
				<th>Patient ID</th>
				<th>Patient Name</th>
				<th>Patient Birthday</th>
				<th>Patient Country</th>
				<th>Patient Email</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${patients}" var="patient">
				<tr>
					<td><c:out value="${patient.idpatient}" /></td>
					<td><c:out value="${patient.name}" /></td>
					<td><c:out value="${patient.birthday}" /></td>
					<td><c:out value="${patient.country}" /></td>
					<td><c:out value="${patient.email}" /></td>
					<td align="center">
						<a href="edit.html?id=${patient.idpatient}">Edit</a>
						<a href="delete.html?id=${patient.idpatient}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>

