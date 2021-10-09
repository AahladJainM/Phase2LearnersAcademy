<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Class Report</title>
</head>
<body>
	<table border="2" width="70%" cellpadding="2">  
		<thead>
			<tr>
				<th>Class ID</th>
				<th>Class Name</th>
				<th>Report Link</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${classes}" var="classVar">
				<tr>
					<td>${classVar.classID}</td>
					<td>${classVar.className}</td>
					<td><a href="reports/${classVar.classID}">Generate Report</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>