/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.object.dto.User;
import process.controll.exceptions.DBFehler;
import process.controll.exceptions.LoginDatenFehler;
import process.controll.exceptions.SQLFehler;
import services.db.JDBCcon;
import services.util.Roles;
import services.util.Views;

/**
 *
 * @author thore
 */
public class LoginControll {
    
    
    public static void check (String name, String password) throws LoginDatenFehler, SQLFehler, DBFehler {
        
        ResultSet set = null;
        String test = "";
        try {
        Statement statement = JDBCcon.getInstance().getStatement();
        
        set = statement.executeQuery("SELECT * FROM db.user WHERE db.user.mail = \'" + name+ "\'"
                                        + "AND db.user.password = \'" + password + "\'" );
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginControll.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLFehler ("Fehler im Backend - Entwickler benachrichtigen");
        }
        
        User user = new User();
        
        try {
            if (set.next()) {
            user.setMail(set.getString(1));
            user.setVorname(set.getString(3));
            } else {
            throw new LoginDatenFehler();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginControll.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            JDBCcon.getInstance().close();
        }
        VaadinSession session = UI.getCurrent().getSession();
        session.setAttribute(Roles.CURRENT_USER, user);
        UI.getCurrent().getNavigator().navigateTo(Views.MAIN);
    }

    public static void logoutUser() {
        UI.getCurrent().getPage().setLocation("/CarLookLtd.clone");
        UI.getCurrent().getSession().close();
        
    }
    
}
