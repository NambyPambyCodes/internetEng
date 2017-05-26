/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "TERMCOURS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Termcours.findAll", query = "SELECT t FROM Termcours t"),
    @NamedQuery(name = "Termcours.findByCoid", query = "SELECT t FROM Termcours t WHERE t.termcoursPK.coid = :coid"),
    @NamedQuery(name = "Termcours.findByTerm", query = "SELECT t FROM Termcours t WHERE t.termcoursPK.term = :term"),
    @NamedQuery(name = "Termcours.findByCgid", query = "SELECT t FROM Termcours t WHERE t.termcoursPK.cgid = :cgid"),
    @NamedQuery(name = "Termcours.findByPid", query = "SELECT t FROM Termcours t WHERE t.pid = :pid"),
    @NamedQuery(name = "Termcours.findByFilterid", query = "SELECT t FROM Termcours t WHERE t.filterid = :filterid")})
public class Termcours implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TermcoursPK termcoursPK;
    @Basic(optional = false)
    @Column(name = "PID")
    private int pid;
    @Basic(optional = false)
    @Column(name = "FILTERID")
    private int filterid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "termcours")
    private Cot cot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "termcours")
    private Collection<Comajt> comajtCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "termcours")
    private Prof prof;

    public Termcours() {
    }

    public Termcours(TermcoursPK termcoursPK) {
        this.termcoursPK = termcoursPK;
    }

    public Termcours(TermcoursPK termcoursPK, int pid, int filterid) {
        this.termcoursPK = termcoursPK;
        this.pid = pid;
        this.filterid = filterid;
    }

    public Termcours(int coid, int term, int cgid) {
        this.termcoursPK = new TermcoursPK(coid, term, cgid);
    }

    public TermcoursPK getTermcoursPK() {
        return termcoursPK;
    }

    public void setTermcoursPK(TermcoursPK termcoursPK) {
        this.termcoursPK = termcoursPK;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getFilterid() {
        return filterid;
    }

    public void setFilterid(int filterid) {
        this.filterid = filterid;
    }

    public Cot getCot() {
        return cot;
    }

    public void setCot(Cot cot) {
        this.cot = cot;
    }

    @XmlTransient
    public Collection<Comajt> getComajtCollection() {
        return comajtCollection;
    }

    public void setComajtCollection(Collection<Comajt> comajtCollection) {
        this.comajtCollection = comajtCollection;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (termcoursPK != null ? termcoursPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Termcours)) {
            return false;
        }
        Termcours other = (Termcours) object;
        if ((this.termcoursPK == null && other.termcoursPK != null) || (this.termcoursPK != null && !this.termcoursPK.equals(other.termcoursPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.Termcours[ termcoursPK=" + termcoursPK + " ]";
    }
    
}
