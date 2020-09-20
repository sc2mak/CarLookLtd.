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
public class RegisterUserDTO {
    
    private String mail = null;
    private String vorname = null;
    private String name = null;
    private String password = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
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
