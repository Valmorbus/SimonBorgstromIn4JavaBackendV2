<%-- 
    Document   : index
    Created on : 2016-maj-10, 11:36:39
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
      
        <h1>Hello World!</h1>
     
            Courses:
        
            <c:forEach items="${allCourses}" var="course">
            <li><a href="students?id=${course.id}">${course.namn}</li>
                
            </c:forEach>
                        
                        
      
      
    </body>
</html>
