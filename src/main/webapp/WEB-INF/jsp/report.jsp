<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Class Report</title>
    </head>
    <body>
        <table border="2" width="70%" cellpadding="2">  
            <thead>
                <tr>
                    <th>Student Name</th>
                    <th>Teacher Name</th>
                    <th>Subject Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${reports}" var="report">
                    <tr>
                        <td>${report.studentName}</td>
                        <td>${report.teacherName}</td>
                        <td>${report.subjectName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>