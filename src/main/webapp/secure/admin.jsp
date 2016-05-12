<%-- 
    Document   : admin
    Created on : 12-May-2016, 09:01:44
    Author     : Simons
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
        <h1>AdminPage</h1>
        
        <h2>All Students:</h2>
          <c:forEach items="${allStudents}" var="students">
              <li> ${students.namn}</li>
                 <form action="" method="POST" id="valueform">
                    
                             
                   <input type="submit" value="delete"/>
                </form>
    </c:forEach>
    
              <h2> All Courses:</h2>
              <c:forEach items="${allCourses}" var="course">
                   <li>${course.namn}</li>
                 <form action="" method="POST" id="valueform">
                     
                                 
                   <input type="submit" value="delete"/>
                </form>
    </c:forEach>
    </body>
</html>
