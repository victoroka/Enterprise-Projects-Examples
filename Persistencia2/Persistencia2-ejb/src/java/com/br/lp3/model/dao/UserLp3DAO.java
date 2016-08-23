/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Userlp3;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author victoroka
 */

public class UserLp3DAO implements GenericDAO<Userlp3>{

    @PersistenceContext(unitName = "persistencia2-ejbPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void create(Userlp3 e) {
        // de novo para gerenciado
        em.persist(e);
    }

    @Override
    public List<Userlp3> read() {
        // NamedQuery Userlp3.findAll na classe Userlp3
        Query query = em.createNamedQuery("Userlp3.findAll");
        return query.getResultList();
    }

    @Override
    public Userlp3 readById(int id) {
        // Lazy: utiliza o objeto somente com ID e buscara o resto somente quando necessario
        return em.find(Userlp3.class, id);
    }

    @Override
    public void update(Userlp3 e) {
        // de desvinculado para gerenciado
        em.merge(e);
    }

    @Override
    public void delete(Userlp3 e) {
        // merge garante que ele esteja no estado gerenciado para ser removido
        em.merge(e);
        em.remove(e);
    }
    
}
