/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.controll.exceptions;

/**
 *
 * @author thore
 */
public class DBFehler extends Exception{
    private String grund = null;
    public  DBFehler (String grund) {
        this.grund = grund; 
    }
     public String getGrund () {
    return this.grund;
     }
     public void setGrund (String grund) {
         this.grund = grund;
     
     }
}
     

