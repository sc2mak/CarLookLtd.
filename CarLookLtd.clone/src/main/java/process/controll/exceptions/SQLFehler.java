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
public class SQLFehler extends Exception{
    private String grund = null;
    
    public SQLFehler (String grund) {
        this.grund = grund;
    }
    
    public void setGrund (String s) {
        this.grund = s;
    }
    
    public String getGrund () {
        return this.grund;
    }
    
}
