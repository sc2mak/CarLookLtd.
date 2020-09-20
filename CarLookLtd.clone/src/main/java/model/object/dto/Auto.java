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
public class Auto {
    public String beschreibung = null;

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

    public String getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(String typ) {
        this.baujahr = typ;
    }
    public String hersteller = null;
    public String baujahr = null;


public Auto (String kennzeichen, String hersteller, String typ) {
    this.beschreibung = kennzeichen;
    this.hersteller = hersteller;
    this.baujahr = typ;
    }
    
    
}

