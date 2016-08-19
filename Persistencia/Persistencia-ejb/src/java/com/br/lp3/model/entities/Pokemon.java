/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author victoroka
 */
// @Entity(name = "tbl_pokemon")
@Entity
public class Pokemon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pokemon;
    
    // @Column(name = "numero")
    private int pokemon_number;
    private String pokemon_name;
    
    // @Transient
    private int pokemon_cp;
    private String pokemon_type;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date pokemon_date;

    public Pokemon(long id_pokemon, int pokemon_number, String pokemon_name, int pokemon_cp, String pokemon_type, Date pokemon_date) {
        this.id_pokemon = id_pokemon;
        this.pokemon_number = pokemon_number;
        this.pokemon_name = pokemon_name;
        this.pokemon_cp = pokemon_cp;
        this.pokemon_type = pokemon_type;
        this.pokemon_date = pokemon_date;
    }

    public Pokemon() {
        this.id_pokemon = -1;
        this.pokemon_number = 1;
        this.pokemon_name = "Bulbasaur";
        this.pokemon_cp = 10;
        this.pokemon_type = "Grass";
        this.pokemon_date = new Date();
    }

    public long getId_pokemon() {
        return id_pokemon;
    }

    public void setId_pokemon(long id_pokemon) {
        this.id_pokemon = id_pokemon;
    }

    public int getPokemon_number() {
        return pokemon_number;
    }

    public void setPokemon_number(int pokemon_number) {
        this.pokemon_number = pokemon_number;
    }

    public String getPokemon_name() {
        return pokemon_name;
    }

    public void setPokemon_name(String pokemon_name) {
        this.pokemon_name = pokemon_name;
    }

    public int getPokemon_cp() {
        return pokemon_cp;
    }

    public void setPokemon_cp(int pokemon_cp) {
        this.pokemon_cp = pokemon_cp;
    }

    public String getPokemon_type() {
        return pokemon_type;
    }

    public void setPokemon_type(String pokemon_type) {
        this.pokemon_type = pokemon_type;
    }

    public Date getPokemon_date() {
        return pokemon_date;
    }

    public void setPokemon_date(Date pokemon_date) {
        this.pokemon_date = pokemon_date;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "id_pokemon=" + id_pokemon + ", pokemon_number=" + pokemon_number + ", pokemon_name=" + pokemon_name + ", pokemon_cp=" + pokemon_cp + ", pokemon_type=" + pokemon_type + ", pokemon_date=" + pokemon_date + '}';
    }   
}
