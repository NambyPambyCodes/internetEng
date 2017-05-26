/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author lenovo
 */
@Embeddable
public class PrecotPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COID")
    private int coid;
    @Basic(optional = false)
    @Column(name = "PRECOID")
    private int precoid;

    public PrecotPK() {
    }

    public PrecotPK(int coid, int precoid) {
        this.coid = coid;
        this.precoid = precoid;
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getPrecoid() {
        return precoid;
    }

    public void setPrecoid(int precoid) {
        this.precoid = precoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) coid;
        hash += (int) precoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecotPK)) {
            return false;
        }
        PrecotPK other = (PrecotPK) object;
        if (this.coid != other.coid) {
            return false;
        }
        if (this.precoid != other.precoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.PrecotPK[ coid=" + coid + ", precoid=" + precoid + " ]";
    }
    
}
