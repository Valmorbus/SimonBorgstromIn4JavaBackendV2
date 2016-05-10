/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.simonborgstromin4javabackend.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author borgs_000
 */
@Entity
@Table(name = "BETYG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Betyg.findAll", query = "SELECT b FROM Betyg b"),
    @NamedQuery(name = "Betyg.findByKursid", query = "SELECT b FROM Betyg b WHERE b.betygPK.kursid = :kursid"),
    @NamedQuery(name = "Betyg.findByStudentid", query = "SELECT b FROM Betyg b WHERE b.betygPK.studentid = :studentid"),
    @NamedQuery(name = "Betyg.findByBetyg", query = "SELECT b FROM Betyg b WHERE b.betyg = :betyg")})
public class Betyg implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BetygPK betygPK;
    @Size(max = 4)
    @Column(name = "BETYG")
    private String betyg;
    @JoinColumn(name = "KURSID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Kurser kurser;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Studenter studenter;

    public Betyg() {
    }

    public Betyg(BetygPK betygPK) {
        this.betygPK = betygPK;
    }

    public Betyg(int kursid, int studentid) {
        this.betygPK = new BetygPK(kursid, studentid);
    }

    public BetygPK getBetygPK() {
        return betygPK;
    }

    public void setBetygPK(BetygPK betygPK) {
        this.betygPK = betygPK;
    }

    public String getBetyg() {
        return betyg;
    }

    public void setBetyg(String betyg) {
        this.betyg = betyg;
    }

    public Kurser getKurser() {
        return kurser;
    }

    public void setKurser(Kurser kurser) {
        this.kurser = kurser;
    }

    public Studenter getStudenter() {
        return studenter;
    }

    public void setStudenter(Studenter studenter) {
        this.studenter = studenter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (betygPK != null ? betygPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Betyg)) {
            return false;
        }
        Betyg other = (Betyg) object;
        if ((this.betygPK == null && other.betygPK != null) || (this.betygPK != null && !this.betygPK.equals(other.betygPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nackademin.simonborgstromin4javabackend.entities.Betyg[ betygPK=" + betygPK + " ]";
    }
    
}
