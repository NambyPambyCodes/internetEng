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
public class ComajtPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COID")
    private int coid;
    @Basic(optional = false)
    @Column(name = "SUBMAJOR")
    private int submajor;
    @Basic(optional = false)
    @Column(name = "FILTERID")
    private int filterid;

    public ComajtPK() {
    }

    public ComajtPK(int coid, int submajor, int filterid) {
        this.coid = coid;
        this.submajor = submajor;
        this.filterid = filterid;
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getSubmajor() {
        return submajor;
    }

    public void setSubmajor(int submajor) {
        this.submajor = submajor;
    }

    public int getFilterid() {
        return filterid;
    }

    public void setFilterid(int filterid) {
        this.filterid = filterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) coid;
        hash += (int) submajor;
        hash += (int) filterid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComajtPK)) {
            return false;
        }
        ComajtPK other = (ComajtPK) object;
        if (this.coid != other.coid) {
            return false;
        }
        if (this.submajor != other.submajor) {
            return false;
        }
        if (this.filterid != other.filterid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.ComajtPK[ coid=" + coid + ", submajor=" + submajor + ", filterid=" + filterid + " ]";
    }
    
}
