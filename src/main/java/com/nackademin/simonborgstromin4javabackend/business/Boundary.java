/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.simonborgstromin4javabackend.business;

import com.nackademin.simonborgstromin4javabackend.entities.Betyg;
import com.nackademin.simonborgstromin4javabackend.entities.Kurser;
import com.nackademin.simonborgstromin4javabackend.entities.Studenter;
import com.nackademin.simonborgstromin4javabackend.facades.BetygFacade;
import com.nackademin.simonborgstromin4javabackend.facades.KurserFacade;
import com.nackademin.simonborgstromin4javabackend.facades.StudenterFacade;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author borgs_000
 */
@Stateless
public class Boundary {

    @Inject
    BetygFacade bf;

    @Inject
    KurserFacade kf;

    @Inject
    StudenterFacade sf;

    public void addStudent(Studenter student) {
        sf.create(student);
    }

    public void addStudent(String namn) {
        Studenter student = new Studenter();
        student.setNamn(namn);
        sf.create(student);
    }

    /*
    public void setStudentCourse(Studenter student, Kurser kurs) {
        student.getBetygCollection().add();
        sf.edit(student);
    }

    public void setStudentCourse(int id, Kurser kurs) {
        Studenter student = sf.find(id);
        student.getBetygCollection().add(kurs);
        sf.edit(student);
    }*/

    public void removeStudent(Studenter student) {
        sf.remove(student);
    }

    public void removeStudent(int id) {
        Studenter student = sf.find(id);
        sf.remove(student);
    }

    public List<Studenter> listAllStudents() {
        return sf.findAll();
    }

    public Studenter findStudent(int id) {
        return sf.find(id);
    }

    /*
    public void setGrade(Studenter student, Betyg betyg) {
        student.getBetygSet().add(betyg);
        sf.edit(student);
    }*/

    public void addCourse(Kurser course) {
        kf.create(course);
    }

    public void addCourse(String namn) {
        Kurser course = new Kurser();
        course.setNamn(namn);
        kf.create(course);
    }

    public void removeCourse(Kurser course) {
        kf.remove(course);
    }

    public void removeCourse(int id) {
        Kurser course = kf.find(id);
        kf.remove(course);
    }

    public List<Kurser> listAllCourses() {
        return kf.findAll();
    }

    public Kurser findCourse(int id) {
        return kf.find(id);
    }

    /*
    public void setGrade(String betyg) {
        Studenter student = sf.find(id);
        student.getBetygSet().add(betyg);
        sf.edit(student);
    }*/
    public void setGrade(int studentId, int courseId, String betygValue) {
        Betyg betyg = new Betyg(studentId, courseId);
        betyg.setBetyg(betygValue);
        bf.edit(betyg);
    }

    public Studenter getStudentFromCourse(int id) {
        Betyg kurs = bf.find(id);
        Studenter student = kurs.getStudenter();
        return student;
    }

    public List<Betyg> getAllStudentFromCourse(Integer id) {
        TypedQuery<Betyg> q = bf.getEntityManager().createNamedQuery("Betyg.findByKursid", Betyg.class);
        return q.setParameter("kursid", id).getResultList();     
    }
    
    public Betyg getStudentToUpdate(int id){
        TypedQuery<Betyg> q = bf.getEntityManager().createNamedQuery("Betyg.findByStudentid", Betyg.class);
        return q.setParameter("studentid", id).getSingleResult();
    }

}
