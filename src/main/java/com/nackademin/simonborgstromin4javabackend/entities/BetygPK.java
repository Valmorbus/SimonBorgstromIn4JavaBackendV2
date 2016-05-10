/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.simonborgstromin4javabackend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Simons
 */
@Embeddable
public class BetygPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "KURSID")
    private int kursid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private int studentid;

    public BetygPK() {
    }

    public BetygPK(int kursid, int studentid) {
        this.kursid = kursid;
        this.studentid = studentid;
    }

    public int getKursid() {
        return kursid;
    }

    public void setKursid(int kursid) {
        this.kursid = kursid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) kursid;
        hash += (int) studentid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetygPK)) {
            return false;
        }
        BetygPK other = (BetygPK) object;
        if (this.kursid != other.kursid) {
            return false;
        }
        if (this.studentid != other.studentid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nackademin.simonborgstromin4javabackend.entities.BetygPK[ kursid=" + kursid + ", studentid=" + studentid + " ]";
    }
    
}
