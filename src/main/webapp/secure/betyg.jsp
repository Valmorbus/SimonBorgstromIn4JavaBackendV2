<%-- 
    Document   : betyg
    Created on : 2016-maj-11, 14:10:10
    Author     : borgs_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

         <c:forEach items="${student}" var="student">
               
                 <form action="" method="POST" id="valueform">
                     <input hidden value = "${student.studenter.id}" name="studentid">${student.studenter.namn}
                     <input hidden value = "${student.kurser.id}" name="kursid"> ${student.kurser.namn}
                     <select name="value" form="valueform">
                    <option  value="null">Set grade</option>
                    <option  value="ig">IG</option>
                    <option  value="g">G</option>
                    <option  value="vg">VG</option>
                    <option  value="mvg">MVG</option>
                    </select>
                   <input type="submit" value="GRADE"/>
                </form>
     
    </c:forEach>
    </body>
</html>
