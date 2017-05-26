/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "STCOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stcot.findAll", query = "SELECT s FROM Stcot s"),
    @NamedQuery(name = "Stcot.findByCoid", query = "SELECT s FROM Stcot s WHERE s.stcotPK.coid = :coid"),
    @NamedQuery(name = "Stcot.findByStid", query = "SELECT s FROM Stcot s WHERE s.stcotPK.stid = :stid"),
    @NamedQuery(name = "Stcot.findByTerm", query = "SELECT s FROM Stcot s WHERE s.term = :term"),
    @NamedQuery(name = "Stcot.findByGrade", query = "SELECT s FROM Stcot s WHERE s.grade = :grade"),
    @NamedQuery(name = "Stcot.findByCredit", query = "SELECT s FROM Stcot s WHERE s.credit = :credit")})
public class Stcot implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StcotPK stcotPK;
    @Basic(optional = false)
    @Column(name = "TERM")
    private int term;
    @Basic(optional = false)
    @Column(name = "GRADE")
    private int grade;
    @Basic(optional = false)
    @Column(name = "CREDIT")
    private int credit;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "stcot")
    private Stt stt;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "stcot")
    private Cot cot;

    public Stcot() {
    }

    public Stcot(StcotPK stcotPK) {
        this.stcotPK = stcotPK;
    }

    public Stcot(StcotPK stcotPK, int term, int grade, int credit) {
        this.stcotPK = stcotPK;
        this.term = term;
        this.grade = grade;
        this.credit = credit;
    }

    public Stcot(int coid, int stid) {
        this.stcotPK = new StcotPK(coid, stid);
    }

    public StcotPK getStcotPK() {
        return stcotPK;
    }

    public void setStcotPK(StcotPK stcotPK) {
        this.stcotPK = stcotPK;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Stt getStt() {
        return stt;
    }

    public void setStt(Stt stt) {
        this.stt = stt;
    }

    public Cot getCot() {
        return cot;
    }

    public void setCot(Cot cot) {
        this.cot = cot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stcotPK != null ? stcotPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stcot)) {
            return false;
        }
        Stcot other = (Stcot) object;
        if ((this.stcotPK == null && other.stcotPK != null) || (this.stcotPK != null && !this.stcotPK.equals(other.stcotPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.Stcot[ stcotPK=" + stcotPK + " ]";
    }
    
}
