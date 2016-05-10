/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.simonborgstromin4javabackend.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Simons
 */
@Entity
@Table(name = "KURSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kurser.findAll", query = "SELECT k FROM Kurser k"),
    @NamedQuery(name = "Kurser.findById", query = "SELECT k FROM Kurser k WHERE k.id = :id"),
    @NamedQuery(name = "Kurser.findByNamn", query = "SELECT k FROM Kurser k WHERE k.namn = :namn")})
public class Kurser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "NAMN")
    private String namn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kurser")
    private Collection<Betyg> betygCollection;

    public Kurser() {
    }

    public Kurser(Integer id) {
        this.id = id;
    }

    public Kurser(Integer id, String namn) {
        this.id = id;
        this.namn = namn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    @XmlTransient
    public Collection<Betyg> getBetygCollection() {
        return betygCollection;
    }

    public void setBetygCollection(Collection<Betyg> betygCollection) {
        this.betygCollection = betygCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kurser)) {
            return false;
        }
        Kurser other = (Kurser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nackademin.simonborgstromin4javabackend.entities.Kurser[ id=" + id + " ]";
    }
    
}
