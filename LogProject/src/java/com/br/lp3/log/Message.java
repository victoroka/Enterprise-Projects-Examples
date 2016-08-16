/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.log;

import com.br.lp3.model.entities.UserLp3;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author VictorOka
 */
public class Message implements Serializable {

    private UserLp3 user;
    private Date date;
    private String message;

    public Message(UserLp3 user, Date date, String message) {
        this.user = user;
        this.date = date;
        this.message = message;
    }

    public UserLp3 getUser() {
        return user;
    }

    public void setUser(UserLp3 user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Log{" + "user=" + user + ", date=" + date + ", message=" + message + '}';
    }
    
}
