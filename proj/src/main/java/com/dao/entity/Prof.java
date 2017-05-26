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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "PROF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prof.findAll", query = "SELECT p FROM Prof p"),
    @NamedQuery(name = "Prof.findById", query = "SELECT p FROM Prof p WHERE p.id = :id"),
    @NamedQuery(name = "Prof.findByName", query = "SELECT p FROM Prof p WHERE p.name = :name"),
    @NamedQuery(name = "Prof.findByUname", query = "SELECT p FROM Prof p WHERE p.uname = :uname"),
    @NamedQuery(name = "Prof.findByPass", query = "SELECT p FROM Prof p WHERE p.pass = :pass"),
    @NamedQuery(name = "Prof.findByEmail", query = "SELECT p FROM Prof p WHERE p.email = :email")})
public class Prof implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "PASS")
    private String pass;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "IMG")
    private Serializable img;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prof")
    private Dept dept;
    @JoinColumn(name = "DID", referencedColumnName = "DID")
    @ManyToOne(optional = false)
    private Dept did;
    @JoinColumn(name = "ID", referencedColumnName = "PID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Termcours termcours;

    public Prof() {
    }

    public Prof(Integer id) {
        this.id = id;
    }

    public Prof(Integer id, String name, String uname, String pass, String email, Serializable img) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.pass = pass;
        this.email = email;
        this.img = img;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Serializable getImg() {
        return img;
    }

    public void setImg(Serializable img) {
        this.img = img;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDid() {
        return did;
    }

    public void setDid(Dept did) {
        this.did = did;
    }

    public Termcours getTermcours() {
        return termcours;
    }

    public void setTermcours(Termcours termcours) {
        this.termcours = termcours;
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
        if (!(object instanceof Prof)) {
            return false;
        }
        Prof other = (Prof) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.entity.Prof[ id=" + id + " ]";
    }
    
}
