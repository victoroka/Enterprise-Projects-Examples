/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Post;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author victoroka
 */
public class PostDAO implements GenericDAO<Post> {
    
    @PersistenceContext(unitName = "persistencia2-ejbPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    @Override
    public void create(Post e) {
        em.persist(e);
    }

    @Override
    public List<Post> read() {
        Query query = em.createNamedQuery("Post.findAll");
        return query.getResultList();
    }

    @Override
    public Post readById(int id) {
        return em.find(Post.class, id);
    }

    @Override
    public void update(Post e) {
        em.merge(e);
    }

    @Override
    public void delete(Post e) {
        em.merge(e);
        em.remove(e);
    }
    
}
