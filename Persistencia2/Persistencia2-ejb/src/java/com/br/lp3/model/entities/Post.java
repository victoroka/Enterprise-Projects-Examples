/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victoroka
 */
@Entity
@Table(name = "POST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByIdPost", query = "SELECT p FROM Post p WHERE p.idPost = :idPost"),
    @NamedQuery(name = "Post.findByPostdate", query = "SELECT p FROM Post p WHERE p.postdate = :postdate"),
    @NamedQuery(name = "Post.findByPosttext", query = "SELECT p FROM Post p WHERE p.posttext = :posttext")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_POST")
    private Long idPost;
    @Column(name = "POSTDATE")
    @Temporal(TemporalType.DATE)
    private Date postdate;
    @Size(max = 140)
    @Column(name = "POSTTEXT")
    private String posttext;
    @OneToMany(mappedBy = "idPost")
    private List<Postlist> postlistList;
    @OneToMany(mappedBy = "idPost")
    private List<Postlike> postlikeList;

    public Post() {
    }

    public Post(Long idPost) {
        this.idPost = idPost;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public String getPosttext() {
        return posttext;
    }

    public void setPosttext(String posttext) {
        this.posttext = posttext;
    }

    @XmlTransient
    public List<Postlist> getPostlistList() {
        return postlistList;
    }

    public void setPostlistList(List<Postlist> postlistList) {
        this.postlistList = postlistList;
    }

    @XmlTransient
    public List<Postlike> getPostlikeList() {
        return postlikeList;
    }

    public void setPostlikeList(List<Postlike> postlikeList) {
        this.postlikeList = postlikeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPost != null ? idPost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.idPost == null && other.idPost != null) || (this.idPost != null && !this.idPost.equals(other.idPost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Post[ idPost=" + idPost + " ]";
    }
    
}
