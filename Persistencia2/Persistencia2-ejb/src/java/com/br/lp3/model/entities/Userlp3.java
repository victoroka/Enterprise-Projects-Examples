/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victoroka
 */
@Entity
@Table(name = "USERLP3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userlp3.findAll", query = "SELECT u FROM Userlp3 u"),
    @NamedQuery(name = "Userlp3.findByIdUserlp3", query = "SELECT u FROM Userlp3 u WHERE u.idUserlp3 = :idUserlp3"),
    @NamedQuery(name = "Userlp3.findByUsername", query = "SELECT u FROM Userlp3 u WHERE u.username = :username"),
    @NamedQuery(name = "Userlp3.findByPassword", query = "SELECT u FROM Userlp3 u WHERE u.password = :password")})
public class Userlp3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USERLP3")
    private Long idUserlp3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "idUserlp3")
    private List<Postlist> postlistList;
    @JoinColumn(name = "ID_USERLP3", referencedColumnName = "ID_USERINFO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Userinfo userinfo;

    public Userlp3() {
    }

    public Userlp3(Long idUserlp3) {
        this.idUserlp3 = idUserlp3;
    }

    public Userlp3(Long idUserlp3, String username, String password) {
        this.idUserlp3 = idUserlp3;
        this.username = username;
        this.password = password;
    }

    public Long getIdUserlp3() {
        return idUserlp3;
    }

    public void setIdUserlp3(Long idUserlp3) {
        this.idUserlp3 = idUserlp3;
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

    @XmlTransient
    public List<Postlist> getPostlistList() {
        return postlistList;
    }

    public void setPostlistList(List<Postlist> postlistList) {
        this.postlistList = postlistList;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserlp3 != null ? idUserlp3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userlp3)) {
            return false;
        }
        Userlp3 other = (Userlp3) object;
        if ((this.idUserlp3 == null && other.idUserlp3 != null) || (this.idUserlp3 != null && !this.idUserlp3.equals(other.idUserlp3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Userlp3[ idUserlp3=" + idUserlp3 + " ]";
    }
    
}
