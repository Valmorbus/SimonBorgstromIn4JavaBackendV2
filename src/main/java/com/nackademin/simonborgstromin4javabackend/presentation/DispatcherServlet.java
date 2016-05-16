/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.simonborgstromin4javabackend.presentation;

import com.nackademin.simonborgstromin4javabackend.business.Boundary;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author borgs_000
 */

// Städa i kod, fixa texter
// sätta upp Roller 
// redirekt vid fel roll



@WebServlet(name = "StudentServlet", urlPatterns = {"/", "/secure/DispatcherServlet"})
public class DispatcherServlet extends HttpServlet {


    @Inject
    Boundary bound;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        String forward = null;

        switch (path) {
            case "/index":
                request.setAttribute("allCourses", bound.listAllCourses());
                forward = "/index.jsp";
                break;
            case "/students":
                int idCourse = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("courseName", bound.findCourse(idCourse).getNamn());
                request.setAttribute("allStudents", bound.getAllStudentFromCourse(idCourse));
                forward = "/students.jsp";
                break;
            case "/secure/betyg":
                int studentid = Integer.parseInt(request.getParameter("id"));
                System.out.println(studentid);
                request.setAttribute("student", bound.getStudentToUpdate(studentid));
                forward = "/secure/betyg.jsp";
                break;
            case "/secure/admin":
                request.setAttribute("allStudents", bound.getAllUnregisteredStudent());
                request.setAttribute("allCourses", bound.getAllUnregisteredCourses());
                request.setAttribute("allGrades", bound.getAllGrades());
                forward = "/secure/admin.jsp";
                break;
            default:
                request.setAttribute("allCourses", bound.listAllCourses());
                forward = "/index.jsp";
                break;
        }

        request.getRequestDispatcher(forward).forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String postType = request.getParameter("postType");
        String url = "admin";
        switch (postType) {
            case "setSimpleGrade" :{
                 try{
                Integer kursId = Integer.valueOf(request.getParameter("kursid"));
                Integer studentid = Integer.valueOf(request.getParameter("studentid"));
                String requ = request.getParameter("value");
                System.out.println(kursId + " " + studentid + " " + requ);
                bound.gradeStudent(studentid, kursId, requ);
                url = "../index";
                } catch(javax.ejb.EJBAccessException e){
                    url = "../index";
                }
                break;    
            }
            case "setGrade":
                try{
                Integer kursId = Integer.valueOf(request.getParameter("kursid"));
                Integer studentid = Integer.valueOf(request.getParameter("studentid"));
                String requ = request.getParameter("value");
                System.out.println(kursId + " " + studentid + " " + requ);
                bound.gradeStudent(studentid, kursId, requ);
                } catch(javax.ejb.EJBAccessException e){
                    url = "admin";
                }
                break;
            case "deleteStudent":
                try{
                int studentId = Integer.parseInt(request.getParameter("studentid"));
                bound.removeStudent(studentId);
                } catch(javax.ejb.EJBAccessException e){
                    url = "admin";
                }
                break;
            case "deleteCourse":
                try{
                int kursToDeleteId = Integer.parseInt(request.getParameter("kursid"));
                bound.removeCourse(kursToDeleteId);
                 } catch(javax.ejb.EJBAccessException e){
                    url = "admin";
                }
                break;
            case "addStudent":
                try{
                String studentToAdd = request.getParameter("name");
                bound.addStudent(studentToAdd);
                } catch(javax.ejb.EJBAccessException e){
                    url = "admin";
                }
                break;
            case "addCourse":
                try{
                String courseToadd = request.getParameter("name");
                bound.addCourse(courseToadd);
                 } catch(javax.ejb.EJBAccessException e){
                    url = "admin";
                }
                break;
            case "logout":{
                 HttpSession session=request.getSession();  
                  session.invalidate();  
                  url = "../index";
                  break;
                  
            }
        }
        response.sendRedirect(url);

    }

   
}
