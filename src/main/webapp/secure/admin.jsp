<%-- 
    Document   : admin
    Created on : 12-May-2016, 09:01:44
    Author     : Simons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>AdminPage</h1>
        
   
          <c:forEach items="${grade}" var="grade">
                   
                 <form action="" method="POST" id="valueform">
                     ${grade.studenter.namn}
                     ${grade.kurser.namn}
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
