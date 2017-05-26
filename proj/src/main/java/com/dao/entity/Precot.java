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
@Table(name = "PRECOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precot.findAll", query = "SELECT p FROM Precot p"),
    @NamedQuery(name = "Precot.findByCoid", query = "SELECT p FROM Precot p WHERE p.precotPK.coid = :coid"),
    @NamedQuery(name = "Precot.findByPrecoid", query = "SELECT p FROM Precot p WHERE p.precotPK.precoid = :precoid")})
public class Precot implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrecotPK precotPK;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "precot")
    private Cot cot;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "precot1")
    private Cot cot1;

    public Precot() {
    }

    public Precot(PrecotPK precotPK) {
        this.precotPK = precotPK;
    }

    public Precot(int coid, int precoid) {
        this.precotPK = new PrecotPK(coid, precoid);
    }

    public PrecotPK getPrecotPK() {
        return precotPK;
    }

    public void setPrecotPK(PrecotPK precotPK) {
        this.precotPK = precotPK;
    }

    public Cot getCot() {
        return cot;
    }

    public void setCot(Cot cot) {
        this.cot = cot;
    }

    public Cot getCot1() {
        return cot1;
    }

    public void setCot1(Cot cot1) {
        this.cot1 = cot1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (precotPK != null ? precotPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precot)) {
            return false;
        }
        Precot other = (Precot) object;
        if ((this.precotPK == null && other.precotPK != null) || (this.precotPK != null && !this.precotPK.equals(other.precotPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.Precot[ precotPK=" + precotPK + " ]";
    }
    
}
