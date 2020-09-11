/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.object.dto.Auto;
import model.object.dto.RegisterCarDTO;
import model.object.dto.User;

/**
 *
 * @author thore
 */
public class RegisterFactory {
    
    public static RegisterCarDTO produceRegisterCarDTO (Auto auto, User user) {
        RegisterCarDTO registerCarDTO = new RegisterCarDTO () ;
        registerCarDTO.setHersteller(auto.getHersteller());
        registerCarDTO.setKennzeichen(auto.getKennzeichen());
        registerCarDTO.setMail(user.getMail());
        registerCarDTO.setTyp(auto.getTyp());
        return registerCarDTO;
    }
    
}
