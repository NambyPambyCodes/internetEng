/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "SUBMAJT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submajt.findAll", query = "SELECT s FROM Submajt s"),
    @NamedQuery(name = "Submajt.findByMajorid", query = "SELECT s FROM Submajt s WHERE s.submajtPK.majorid = :majorid"),
    @NamedQuery(name = "Submajt.findBySubmajorid", query = "SELECT s FROM Submajt s WHERE s.submajtPK.submajorid = :submajorid")})
public class Submajt implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubmajtPK submajtPK;
    @JoinColumn(name = "SUBMAJORID", referencedColumnName = "SUBMAJOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comajt comajt;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "submajt")
    private Dept dept;

    public Submajt() {
    }

    public Submajt(SubmajtPK submajtPK) {
        this.submajtPK = submajtPK;
    }

    public Submajt(int majorid, int submajorid) {
        this.submajtPK = new SubmajtPK(majorid, submajorid);
    }

    public SubmajtPK getSubmajtPK() {
        return submajtPK;
    }

    public void setSubmajtPK(SubmajtPK submajtPK) {
        this.submajtPK = submajtPK;
    }

    public Comajt getComajt() {
        return comajt;
    }

    public void setComajt(Comajt comajt) {
        this.comajt = comajt;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (submajtPK != null ? submajtPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submajt)) {
            return false;
        }
        Submajt other = (Submajt) object;
        if ((this.submajtPK == null && other.submajtPK != null) || (this.submajtPK != null && !this.submajtPK.equals(other.submajtPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.Submajt[ submajtPK=" + submajtPK + " ]";
    }
    
}
