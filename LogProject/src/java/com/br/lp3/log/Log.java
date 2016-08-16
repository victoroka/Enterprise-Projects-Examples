/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VictorOka
 */
public class Log implements Serializable {
    
    private List<Message> messages;
    private String fileName;

    public Log(String fileName) {
        messages = new ArrayList<>();
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        String str = "";
        for (Message message : messages) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            str += sdf.format(message.getDate()) 
                    + " - " + message.getUser().getUsername() 
                    + " - " + message.getMessage() + "\n";
        }
        return str;
    }
    
    public void addMessage(Message msg) {
        openLog(fileName);
        messages.add(msg);
        saveLog(fileName);
    }
    
    public boolean saveLog(String fileName) {
        boolean response = false;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
            response = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
    
    public void openLog(String fileName) {
        Log log = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            log = (Log)ois.readObject();
            this.messages = log.getMessages();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Message> getMessages() {
        return messages;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
}
