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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "COT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cot.findAll", query = "SELECT c FROM Cot c"),
    @NamedQuery(name = "Cot.findById", query = "SELECT c FROM Cot c WHERE c.id = :id"),
    @NamedQuery(name = "Cot.findByName", query = "SELECT c FROM Cot c WHERE c.name = :name"),
    @NamedQuery(name = "Cot.findByDepid", query = "SELECT c FROM Cot c WHERE c.depid = :depid"),
    @NamedQuery(name = "Cot.findByCredit", query = "SELECT c FROM Cot c WHERE c.credit = :credit"),
    @NamedQuery(name = "Cot.findByType", query = "SELECT c FROM Cot c WHERE c.type = :type")})
public class Cot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "DEPID")
    private long depid;
    @Basic(optional = false)
    @Column(name = "CREDIT")
    private int credit;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @JoinColumn(name = "ID", referencedColumnName = "COID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Comajt comajt;
    @JoinColumn(name = "ID", referencedColumnName = "COID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Precot precot;
    @JoinColumn(name = "ID", referencedColumnName = "PRECOID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Precot precot1;
    @JoinColumn(name = "ID", referencedColumnName = "COID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Stcot stcot;
    @JoinColumn(name = "ID", referencedColumnName = "COID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Termcours termcours;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cot")
    private Dept dept;

    public Cot() {
    }

    public Cot(Long id) {
        this.id = id;
    }

    public Cot(Long id, String name, long depid, int credit, String type) {
        this.id = id;
        this.name = name;
        this.depid = depid;
        this.credit = credit;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDepid() {
        return depid;
    }

    public void setDepid(long depid) {
        this.depid = depid;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Comajt getComajt() {
        return comajt;
    }

    public void setComajt(Comajt comajt) {
        this.comajt = comajt;
    }

    public Precot getPrecot() {
        return precot;
    }

    public void setPrecot(Precot precot) {
        this.precot = precot;
    }

    public Precot getPrecot1() {
        return precot1;
    }

    public void setPrecot1(Precot precot1) {
        this.precot1 = precot1;
    }

    public Stcot getStcot() {
        return stcot;
    }

    public void setStcot(Stcot stcot) {
        this.stcot = stcot;
    }

    public Termcours getTermcours() {
        return termcours;
    }

    public void setTermcours(Termcours termcours) {
        this.termcours = termcours;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cot)) {
            return false;
        }
        Cot other = (Cot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.Cot[ id=" + id + " ]";
    }
    
}
