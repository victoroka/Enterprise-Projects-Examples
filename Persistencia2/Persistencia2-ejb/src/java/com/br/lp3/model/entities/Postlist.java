/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victoroka
 */
@Entity
@Table(name = "POSTLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postlist.findAll", query = "SELECT p FROM Postlist p"),
    @NamedQuery(name = "Postlist.findByIdPostlist", query = "SELECT p FROM Postlist p WHERE p.idPostlist = :idPostlist")})
public class Postlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_POSTLIST")
    private Long idPostlist;
    @JoinColumn(name = "ID_POST", referencedColumnName = "ID_POST")
    @ManyToOne
    private Post idPost;
    @JoinColumn(name = "ID_USERLP3", referencedColumnName = "ID_USERLP3")
    @ManyToOne
    private Userlp3 idUserlp3;

    public Postlist() {
    }

    public Postlist(Long idPostlist) {
        this.idPostlist = idPostlist;
    }

    public Long getIdPostlist() {
        return idPostlist;
    }

    public void setIdPostlist(Long idPostlist) {
        this.idPostlist = idPostlist;
    }

    public Post getIdPost() {
        return idPost;
    }

    public void setIdPost(Post idPost) {
        this.idPost = idPost;
    }

    public Userlp3 getIdUserlp3() {
        return idUserlp3;
    }

    public void setIdUserlp3(Userlp3 idUserlp3) {
        this.idUserlp3 = idUserlp3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostlist != null ? idPostlist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postlist)) {
            return false;
        }
        Postlist other = (Postlist) object;
        if ((this.idPostlist == null && other.idPostlist != null) || (this.idPostlist != null && !this.idPostlist.equals(other.idPostlist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Postlist[ idPostlist=" + idPostlist + " ]";
    }
    
}
