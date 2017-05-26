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
@Table(name = "STT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stt.findAll", query = "SELECT s FROM Stt s"),
    @NamedQuery(name = "Stt.findById", query = "SELECT s FROM Stt s WHERE s.id = :id"),
    @NamedQuery(name = "Stt.findByName", query = "SELECT s FROM Stt s WHERE s.name = :name"),
    @NamedQuery(name = "Stt.findByUname", query = "SELECT s FROM Stt s WHERE s.uname = :uname"),
    @NamedQuery(name = "Stt.findByPassword", query = "SELECT s FROM Stt s WHERE s.password = :password"),
    @NamedQuery(name = "Stt.findByMajor", query = "SELECT s FROM Stt s WHERE s.major = :major"),
    @NamedQuery(name = "Stt.findBySubmajor", query = "SELECT s FROM Stt s WHERE s.submajor = :submajor"),
    @NamedQuery(name = "Stt.findByEnteranceyear", query = "SELECT s FROM Stt s WHERE s.enteranceyear = :enteranceyear"),
    @NamedQuery(name = "Stt.findByEmail", query = "SELECT s FROM Stt s WHERE s.email = :email")})
public class Stt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "UNAME")
    private String uname;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "MAJOR")
    private String major;
    @Basic(optional = false)
    @Column(name = "SUBMAJOR")
    private String submajor;
    @Basic(optional = false)
    @Column(name = "ENTERANCEYEAR")
    private int enteranceyear;
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "ID", referencedColumnName = "STID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Stcot stcot;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "stt")
    private Dept dept;

    public Stt() {
    }

    public Stt(Integer id) {
        this.id = id;
    }

    public Stt(Integer id, String name, String uname, String password, String major, String submajor, int enteranceyear) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.password = password;
        this.major = major;
        this.submajor = submajor;
        this.enteranceyear = enteranceyear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSubmajor() {
        return submajor;
    }

    public void setSubmajor(String submajor) {
        this.submajor = submajor;
    }

    public int getEnteranceyear() {
        return enteranceyear;
    }

    public void setEnteranceyear(int enteranceyear) {
        this.enteranceyear = enteranceyear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Stcot getStcot() {
        return stcot;
    }

    public void setStcot(Stcot stcot) {
        this.stcot = stcot;
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
        if (!(object instanceof Stt)) {
            return false;
        }
        Stt other = (Stt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.Stt[ id=" + id + " ]";
    }
    
}
