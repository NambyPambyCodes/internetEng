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
public class TermcoursPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COID")
    private int coid;
    @Basic(optional = false)
    @Column(name = "TERM")
    private int term;
    @Basic(optional = false)
    @Column(name = "CGID")
    private int cgid;

    public TermcoursPK() {
    }

    public TermcoursPK(int coid, int term, int cgid) {
        this.coid = coid;
        this.term = term;
        this.cgid = cgid;
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCgid() {
        return cgid;
    }

    public void setCgid(int cgid) {
        this.cgid = cgid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) coid;
        hash += (int) term;
        hash += (int) cgid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TermcoursPK)) {
            return false;
        }
        TermcoursPK other = (TermcoursPK) object;
        if (this.coid != other.coid) {
            return false;
        }
        if (this.term != other.term) {
            return false;
        }
        if (this.cgid != other.cgid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.TermcoursPK[ coid=" + coid + ", term=" + term + ", cgid=" + cgid + " ]";
    }
    
}
