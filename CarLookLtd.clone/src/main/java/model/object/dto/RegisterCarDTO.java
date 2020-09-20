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
public class RegisterCarDTO {

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(String typ) {
        this.baujahr = typ;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String kennzeichen) {
        this.beschreibung = kennzeichen;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    
    private String mail = null;
    private String baujahr = null;
    private String beschreibung = null;
    private String hersteller = null;
    
    
    
}
