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
public class SubmajtPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "MAJORID")
    private int majorid;
    @Basic(optional = false)
    @Column(name = "SUBMAJORID")
    private int submajorid;

    public SubmajtPK() {
    }

    public SubmajtPK(int majorid, int submajorid) {
        this.majorid = majorid;
        this.submajorid = submajorid;
    }

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

    public int getSubmajorid() {
        return submajorid;
    }

    public void setSubmajorid(int submajorid) {
        this.submajorid = submajorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) majorid;
        hash += (int) submajorid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubmajtPK)) {
            return false;
        }
        SubmajtPK other = (SubmajtPK) object;
        if (this.majorid != other.majorid) {
            return false;
        }
        if (this.submajorid != other.submajorid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.SubmajtPK[ majorid=" + majorid + ", submajorid=" + submajorid + " ]";
    }
    
}
