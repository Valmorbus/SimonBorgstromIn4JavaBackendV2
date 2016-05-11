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
        <h1>Hello World!</h1>


        <h2>Studenter i kurs ${courseName} </h2>
        <c:forEach items="${allStudents}" var="studenter">
        <li> 
            <a href="betyg?idStudent=${studenter.studenter.id}">${studenter.studenter.namn}</a>
           
                <form action="/students" method="POST" id="valueform">
                   <input type="submit" value="GRADE"/>
                </form>
                    <select name="value" form="valueform">
                    <option  value="null">Set grade</option>
                    <option  value="ig">IG</option>
                    <option  value="g">G</option>
                    <option  value="vg">VG</option>
                    <option  value="mvg">MVG</option>
                    </select>
                 
                
        </li>
    </c:forEach>
        


</body>
</html>
