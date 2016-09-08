/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Postlike;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author victoroka
 */
public class PostlikeDAO implements GenericDAO<Postlike> {

    @PersistenceContext(unitName = "persistencia2-ejbPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    @Override
    public void create(Postlike e) {
        em.persist(e);
    }

    @Override
    public List<Postlike> read() {
        Query query = em.createNamedQuery("Postlike.findAll");
        return query.getResultList();
    }

    @Override
    public Postlike readById(int id) {
        return em.find(Postlike.class, id);
    }

    @Override
    public void update(Postlike e) {
        em.merge(e);
    }

    @Override
    public void delete(Postlike e) {
        em.merge(e);
        em.remove(e);
    }
    
}
