/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model;

import java.util.List;

/**
 *
 * @author victoroka
 */
public interface GenericDAO<E> {
    public void create(E e);
    public List<E> read();
    public void update(E e);
    public void delete(E e);
    public E readById(long id);
}
