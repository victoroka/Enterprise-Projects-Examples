/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model;

import com.br.lp3.model.entities.Pokemon;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author victoroka
 */
@Stateful
@LocalBean
public class PokemonDAO implements GenericDAO<Pokemon> {
    @PersistenceContext(name = "pokemon-warPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    @Override
    public void create(Pokemon e) {
        em.persist(e);
    }

    @Override
    public List<Pokemon> read() {
        Query query = em.createQuery("SELECT p FROM Pokemon p"); // Pokemon = classe / p = objeto
        return (List<Pokemon>)query.getResultList();
    }

    @Override
    public void update(Pokemon e) {
        em.merge(e);
    }

    @Override
    public void delete(Pokemon e) {
        em.remove(e);
    }

    @Override
    public Pokemon readById(long id) {
        // Eager
        return em.find(Pokemon.class, id);
        
        // Lazy
        //return em.getReference(Pokemon.class, id);
    }
    
}
