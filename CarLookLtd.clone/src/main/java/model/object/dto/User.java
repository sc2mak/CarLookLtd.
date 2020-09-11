/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object.dto;

/**
 *
 * @author thore
 */
public class User {
    
    
    private String mail = null;
    private String vorname = null;
    
    
    public String getVorname () {
        return this.vorname;
    }
    
    public void setVorname (String vorname){
        this.vorname = vorname;
    }


    
    public String getMail () {
        return this.mail;
    }
    
    public void setMail (String mail){
        this.mail = mail;
    }
}
