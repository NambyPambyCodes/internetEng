/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COMAJT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comajt.findAll", query = "SELECT c FROM Comajt c"),
    @NamedQuery(name = "Comajt.findByCoid", query = "SELECT c FROM Comajt c WHERE c.comajtPK.coid = :coid"),
    @NamedQuery(name = "Comajt.findBySubmajor", query = "SELECT c FROM Comajt c WHERE c.comajtPK.submajor = :submajor"),
    @NamedQuery(name = "Comajt.findByFilterid", query = "SELECT c FROM Comajt c WHERE c.comajtPK.filterid = :filterid")})
public class Comajt implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComajtPK comajtPK;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "comajt")
    private Cot cot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comajt")
    private Collection<Submajt> submajtCollection;
    @JoinColumn(name = "FILTERID", referencedColumnName = "FILTERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Termcours termcours;

    public Comajt() {
    }

    public Comajt(ComajtPK comajtPK) {
        this.comajtPK = comajtPK;
    }

    public Comajt(int coid, int submajor, int filterid) {
        this.comajtPK = new ComajtPK(coid, submajor, filterid);
    }

    public ComajtPK getComajtPK() {
        return comajtPK;
    }

    public void setComajtPK(ComajtPK comajtPK) {
        this.comajtPK = comajtPK;
    }

    public Cot getCot() {
        return cot;
    }

    public void setCot(Cot cot) {
        this.cot = cot;
    }

    @XmlTransient
    public Collection<Submajt> getSubmajtCollection() {
        return submajtCollection;
    }

    public void setSubmajtCollection(Collection<Submajt> submajtCollection) {
        this.submajtCollection = submajtCollection;
    }

    public Termcours getTermcours() {
        return termcours;
    }

    public void setTermcours(Termcours termcours) {
        this.termcours = termcours;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comajtPK != null ? comajtPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comajt)) {
            return false;
        }
        Comajt other = (Comajt) object;
        if ((this.comajtPK == null && other.comajtPK != null) || (this.comajtPK != null && !this.comajtPK.equals(other.comajtPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.Comajt[ comajtPK=" + comajtPK + " ]";
    }
    
}
