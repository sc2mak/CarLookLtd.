/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control;

import com.vaadin.ui.UI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.object.dto.Auto;
import model.object.dto.User;
import process.controll.exceptions.DBFehler;
import process.controll.exceptions.SQLFehler;
import services.db.JDBCcon;
import services.util.Roles;

/**
 *
 * @author thore
 */
public class AutoAusgabe {
    private static AutoAusgabe ausgabe = null;
    public static AutoAusgabe getInstance () {
        if (ausgabe == null) {
            ausgabe = new AutoAusgabe();
        }
        return ausgabe;
    }
    public static ArrayList<Auto> list = null;
    
    public ArrayList<Auto> ausgabe () throws SQLFehler, DBFehler {
        ResultSet set = null;
        list = new ArrayList<Auto>();
        User user = (User) UI.getCurrent().getSession().getAttribute(Roles.CURRENT_USER);
        Statement statement = JDBCcon.getInstance().getStatement();
        try {
        set = statement.executeQuery("SELECT * FROM db.auto WHERE db.auto.vertrieblerMail = \'" + user.getMail()+ "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginControll.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLFehler ("Fehler im Backend - Entwickler benachrichtigen");
        }
        try {
            if (set.next()) {
            Auto auto = new Auto(set.getString(1), set.getString(2), set.getString(3));
            list.add(auto);
            while (set.next()) {
                Auto autoNext = new Auto(set.getString(1), set.getString(2), set.getString(3));
                list.add(autoNext);
            }
            } else {
                throw new DBFehler("Kein Autovorhanden");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginControll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
