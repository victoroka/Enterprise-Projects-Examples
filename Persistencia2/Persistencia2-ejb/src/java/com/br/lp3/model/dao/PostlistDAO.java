/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Postlist;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author victoroka
 */
public class PostlistDAO implements GenericDAO<Postlist> {
    
    @PersistenceContext(unitName = "persistencia2-ejbPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void create(Postlist e) {
        em.persist(e);
    }

    @Override
    public List<Postlist> read() {
        Query query = em.createNamedQuery("Postlist.findAll");
        return query.getResultList();
    }

    @Override
    public Postlist readById(int id) {
        return em.find(Postlist.class, id);
    }

    @Override
    public void update(Postlist e) {
        em.merge(e);
    }

    @Override
    public void delete(Postlist e) {
        em.merge(e);
        em.remove(e);
    }
    
}
