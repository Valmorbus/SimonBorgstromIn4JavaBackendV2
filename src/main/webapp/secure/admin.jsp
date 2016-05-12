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

            <form action="" method="POST" id="valueform">
                <input hidden value = "${students.id}" name="studentid">${students.namn} <input type="submit" value="delete"/>


            </form>
        </c:forEach>

        <h2> All Courses:</h2>
        <c:forEach items="${allCourses}" var="course">

            <form action="" method="POST" id="valueform">
                <input hidden value = "${course.id}" name="studentid">${course.namn}
                <input type="submit" value="delete"/>
            </form>
        </c:forEach>

        <h2>Grade</h2>
        <c:forEach items="${allGrades}" var="allGrades">

            <form action="" method="POST" id="valueform">
                <input hidden value = "${allGrades.studenter.id}" name="studentid">${allGrades.studenter.namn}
                <input hidden value = "${allGrades.kurser.id}" name="kursid"> ${allGrades.kurser.namn}
                <input hidden value = "${allGrades.kurser.id}" name="kursid"> ${allGrades.betyg}
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
