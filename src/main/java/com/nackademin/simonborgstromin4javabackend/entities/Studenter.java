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
@Table(name = "STUDENTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studenter.findAll", query = "SELECT s FROM Studenter s"),
    @NamedQuery(name = "Studenter.findById", query = "SELECT s FROM Studenter s WHERE s.id = :id"),
    @NamedQuery(name = "Studenter.findByNamn", query = "SELECT s FROM Studenter s WHERE s.namn = :namn"),
    @NamedQuery(name = "Studenter.findUnregistered", query= "SELECT s FROM Studenter s WHERE NOT EXISTS (SELECT c FROM s.betygCollection c)"
   )})
public class Studenter implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studenter")
    private Collection<Betyg> betygCollection;

    public Studenter() {
    }

    public Studenter(Integer id) {
        this.id = id;
    }

    public Studenter(Integer id, String namn) {
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
        if (!(object instanceof Studenter)) {
            return false;
        }
        Studenter other = (Studenter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nackademin.simonborgstromin4javabackend.entities.Studenter[ id=" + id + " ]";
    }
    
}
