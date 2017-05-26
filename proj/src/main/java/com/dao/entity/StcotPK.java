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
public class StcotPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COID")
    private int coid;
    @Basic(optional = false)
    @Column(name = "STID")
    private int stid;

    public StcotPK() {
    }

    public StcotPK(int coid, int stid) {
        this.coid = coid;
        this.stid = stid;
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) coid;
        hash += (int) stid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StcotPK)) {
            return false;
        }
        StcotPK other = (StcotPK) object;
        if (this.coid != other.coid) {
            return false;
        }
        if (this.stid != other.stid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.StcotPK[ coid=" + coid + ", stid=" + stid + " ]";
    }
    
}
