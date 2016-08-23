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
@Table(name = "POSTLIKE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postlike.findAll", query = "SELECT p FROM Postlike p"),
    @NamedQuery(name = "Postlike.findByIdPostlike", query = "SELECT p FROM Postlike p WHERE p.idPostlike = :idPostlike"),
    @NamedQuery(name = "Postlike.findByPoststatus", query = "SELECT p FROM Postlike p WHERE p.poststatus = :poststatus")})
public class Postlike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_POSTLIKE")
    private Long idPostlike;
    @Column(name = "POSTSTATUS")
    private Integer poststatus;
    @JoinColumn(name = "ID_POST", referencedColumnName = "ID_POST")
    @ManyToOne
    private Post idPost;

    public Postlike() {
    }

    public Postlike(Long idPostlike) {
        this.idPostlike = idPostlike;
    }

    public Long getIdPostlike() {
        return idPostlike;
    }

    public void setIdPostlike(Long idPostlike) {
        this.idPostlike = idPostlike;
    }

    public Integer getPoststatus() {
        return poststatus;
    }

    public void setPoststatus(Integer poststatus) {
        this.poststatus = poststatus;
    }

    public Post getIdPost() {
        return idPost;
    }

    public void setIdPost(Post idPost) {
        this.idPost = idPost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostlike != null ? idPostlike.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postlike)) {
            return false;
        }
        Postlike other = (Postlike) object;
        if ((this.idPostlike == null && other.idPostlike != null) || (this.idPostlike != null && !this.idPostlike.equals(other.idPostlike))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Postlike[ idPostlike=" + idPostlike + " ]";
    }
    
}
