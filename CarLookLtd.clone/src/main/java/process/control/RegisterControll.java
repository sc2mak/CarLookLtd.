/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control;

import com.vaadin.ui.UI;
import model.dao.RegisterDAO;
import model.object.dto.RegisterUserDTO;
import process.controll.exceptions.LoginDatenFehler;
import process.controll.exceptions.RegisterDatenFehler;
import services.util.Views;

/**
 *
 * @author thore
 */
public class RegisterControll {
    
    private static RegisterControll regCon = null;
    
    public static RegisterControll getInstance () {
        if (regCon == null) {
            regCon = new RegisterControll();
        }
        return regCon;
    }
    
     public static void register (RegisterUserDTO rud) throws RegisterDatenFehler, LoginDatenFehler {
         String check = rud.getMail();
         String vergleich = check.substring(check.indexOf('@'), check.length());
         String firmenmail = "@carlook.de";
         if (!vergleich.equalsIgnoreCase(firmenmail)) {
             throw new LoginDatenFehler ();
         }
        boolean test = RegisterDAO.getInstance().registerUser(rud);    
        UI.getCurrent().getNavigator().navigateTo(Views.START);
       
       
    }
    
}
