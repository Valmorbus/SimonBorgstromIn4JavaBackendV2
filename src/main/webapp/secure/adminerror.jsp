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
        <h2 style="color:#069">You do not have permission to do these changes</h2>
        <h2>All Students not in courses:</h2>
        <table>
            <thead><td>Student</td><td>Delete</td></thead>
        <tbody>
            <c:forEach items="${allStudents}" var="students">
                <tr>
            <form action="" method="POST" id="valueform">
                <input type="hidden" name="postType" value="deleteStudent">
                <td> <input hidden value = "${students.id}" name="studentid">${students.namn} </td>
                <td> <input type="submit" value="delete"/></td>


            </form>
        </tr>
    </c:forEach>
</tbody>
</table>
<h2> All Courses without students:</h2>
<table>
    <thead><td>Kurs</td><td>Delete</td></thead>
<tbody>
    <c:forEach items="${allCourses}" var="course">
        <tr>
    <form action="" method="POST" id="valueform">
        <input type="hidden" name="postType" value="deleteCourse">
        <td>     <input hidden value = "${course.id}" name="kursid">${course.namn}</td>
        <td>   <input type="submit" value="delete"/></td>
    </form>
</tr>
</c:forEach>
</tbody>
</table>


 </table>
        <h2>Add student:</h2>
        <form method="POST" action="">
            <input type="hidden" name="postType" value="addStudent">
            Namn:<br>
            <input type="text" name="name">
            <input type="submit" value="Spara elev">
        </form>
        <hr>
        <h2>Add course:</h2>
        <form method="POST" action="">
            <input type="hidden" name="postType" value="addCourse">
            Namn:<br>
            <input type="text" name="name">
            <input type="submit" value="Spara Kurs">
        </form>



<h2>Grade students in ongoing courses</h2>

<table>
    <thead><td>Student</td><td>Kurs</td><td>Betyg</td><td>Sätt Betyg</td><td>Skicka in</td></thead>
<tbody>
    <c:forEach items="${allGrades}" var="allGrades">
        <tr>
    <form action="" method="POST" id="valueform">
        <input type="hidden" name="postType" value="setGrade">
        <td>   <input hidden value = "${allGrades.studenter.id}" name="studentid">${allGrades.studenter.namn} </td>
        <td>     <input hidden value = "${allGrades.kurser.id}" name="kursid"> ${allGrades.kurser.namn}</td>
        <td> <input hidden value = "${allGrades.kurser.id}" name="currGrade"> ${allGrades.betyg}</td>

        <td>       <select name="value" form="valueform">
                <option  value="null">Set grade</option>
                <option  value="ig">IG</option>
                <option  value="g">G</option>
                <option  value="vg">VG</option>
                <option  value="mvg">MVG</option>
            </select></td>
        <td>  <input type="submit" value="GRADE"/><td>
    </form>
</tr>
</c:forEach>
</tbody>
</table>

<br><br>
<h2>Register students to courses</h2>
<form action="" method="POST" id="registerform">
        <input type="hidden" name="postType" value="setStudentToCourse">
        <select name="regStudentId" form="registerform">
    <c:forEach items="${allStudents}" var="studenter">

        <option  value="${studenter.id}">${studenter.namn}</option>

    </c:forEach>
        <c:forEach items="${allGrades}" var="allGrades">

        <option  value="${allGrades.studenter.id}">${allGrades.studenter.namn}</option>

    </c:forEach>
</select>
<select name="regKursId" form="registerform">
    <c:forEach items="${allCourses}" var="course">
        <option  value="${course.id}">${course.namn}</option>
    </c:forEach>
        <c:forEach items="${allGrades}" var="allGrades">

        <option  value="${allGrades.kurser.id}">${allGrades.kurser.namn}</option>

    </c:forEach>
</select>
 <input type="submit" value="Register"/>
   </form>
<br><br>


<form action="" method="POST" id="">
        <input type="hidden" name="postType" value="logout">
        <input type="submit" value="LOGOUT"/>
</form>

</body>
</html>
