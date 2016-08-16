/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;

/**
 *
 * @author VictorOka
 */
public class UserLp3 implements Serializable {
    
    private long idUserLp3;
    private String username;
    private String password;

    public UserLp3() {
        this.idUserLp3 = -1;
        this.username = "user";
        this.password = "123";
    }

    public UserLp3(String username, String password) {
        this.idUserLp3 = -1;
        this.username = username;
        this.password = password;
    }

    public UserLp3(long idUserLp3, String username, String password) {
        this.idUserLp3 = idUserLp3;
        this.username = username;
        this.password = password;
    }

    public long getIdUserLp3() {
        return idUserLp3;
    }

    public void setIdUserLp3(long idUserLp3) {
        this.idUserLp3 = idUserLp3;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLp3{" + "idUserLp3=" + idUserLp3 + ", username=" + username + ", password=" + password + '}';
    } 
}
