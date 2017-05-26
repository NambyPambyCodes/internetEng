/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao.entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "DEPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d"),
    @NamedQuery(name = "Dept.findByDid", query = "SELECT d FROM Dept d WHERE d.did = :did"),
    @NamedQuery(name = "Dept.findByPid", query = "SELECT d FROM Dept d WHERE d.pid = :pid"),
    @NamedQuery(name = "Dept.findByName", query = "SELECT d FROM Dept d WHERE d.name = :name"),
    @NamedQuery(name = "Dept.findByUsername", query = "SELECT d FROM Dept d WHERE d.username = :username"),
    @NamedQuery(name = "Dept.findByPassword", query = "SELECT d FROM Dept d WHERE d.password = :password")})
public class Dept implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DID")
    private Integer did;
    @Basic(optional = false)
    @Column(name = "PID")
    private int pid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "DID", referencedColumnName = "DEPID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cot cot;
    @JoinColumn(name = "DID", referencedColumnName = "DID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prof prof;
    @JoinColumn(name = "DID", referencedColumnName = "MAJOR", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Stt stt;
    @JoinColumn(name = "DID", referencedColumnName = "MAJORID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Submajt submajt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "did")
    private Collection<Prof> profCollection;

    public Dept() {
    }

    public Dept(Integer did) {
        this.did = did;
    }

    public Dept(Integer did, int pid, String name, String username, String password) {
        this.did = did;
        this.pid = pid;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cot getCot() {
        return cot;
    }

    public void setCot(Cot cot) {
        this.cot = cot;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public Stt getStt() {
        return stt;
    }

    public void setStt(Stt stt) {
        this.stt = stt;
    }

    public Submajt getSubmajt() {
        return submajt;
    }

    public void setSubmajt(Submajt submajt) {
        this.submajt = submajt;
    }

    @XmlTransient
    public Collection<Prof> getProfCollection() {
        return profCollection;
    }

    public void setProfCollection(Collection<Prof> profCollection) {
        this.profCollection = profCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (did != null ? did.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dept)) {
            return false;
        }
        Dept other = (Dept) object;
        if ((this.did == null && other.did != null) || (this.did != null && !this.did.equals(other.did))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.Dept[ did=" + did + " ]";
    }
    
}
