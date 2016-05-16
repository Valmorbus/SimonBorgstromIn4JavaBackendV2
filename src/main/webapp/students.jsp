<%-- 
    Document   : students
    Created on : 2016-maj-10, 12:21:29
    Author     : borgs_000
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${courseName} studentlista</h1>


        <h2>Studenter i kurs ${courseName} </h2>
        <c:forEach items="${allStudents}" var="studenter">
        <li> 
           
            <a href="secure/betyg?id=${studenter.studenter.id}">${studenter.studenter.namn}</a>
                
        </li>
    </c:forEach>
        


</body>
</html>
