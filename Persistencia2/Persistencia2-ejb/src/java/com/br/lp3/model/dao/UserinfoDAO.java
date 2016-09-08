/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Userinfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author victoroka
 */
public class UserinfoDAO implements GenericDAO<Userinfo> {
    
    @PersistenceContext(unitName = "persistencia2-ejbPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    @Override
    public void create(Userinfo e) {
        // de novo para gerenciado
        em.persist(e);
    }

    @Override
    public List<Userinfo> read() {
        // NamedQuery Userinfo.findAll na classe Userlp3
        Query query = em.createNamedQuery("Userinfo.findAll");
        return query.getResultList();
    }

    @Override
    public Userinfo readById(int id) {
        // Lazy: utiliza o objeto somente com ID e buscara o resto somente quando necessario
        return em.find(Userinfo.class, id);
    }

    @Override
    public void update(Userinfo e) {
        // de desvinculado para gerenciado
        em.merge(e);
    }

    @Override
    public void delete(Userinfo e) {
        // merge garante que ele esteja no estado gerenciado para ser removido
        em.merge(e);
        em.remove(e);    
    }
}
