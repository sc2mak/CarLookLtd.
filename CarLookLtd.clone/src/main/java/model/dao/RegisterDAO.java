/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.vaadin.ui.UI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.object.dto.Auto;
import model.object.dto.RegisterCarDTO;
import model.object.dto.RegisterUserDTO;
import model.object.dto.User;
import process.control.LoginControll;
import process.controll.exceptions.DBFehler;
import process.controll.exceptions.LoginDatenFehler;
import process.controll.exceptions.SQLFehler;
import services.db.JDBCcon;
import services.util.Roles;

/**
 *
 * @author thore
 */
public class RegisterDAO extends AbstractDAO {
    private static RegisterDAO registerDAO = null;
    
    private RegisterDAO () {
        
    }
    
    public static RegisterDAO getInstance (){
        if (registerDAO == null) {
            registerDAO = new RegisterDAO();
        }
        return registerDAO;
    }    
     public boolean registerAuto (RegisterCarDTO rcd) {
         String sql = "insert into db.auto values (?,?,?,?,DEFAULT)";
         PreparedStatement statement = this.getPreparedStatement(sql);
     
        try {
            statement.setString(1, rcd.getBeschreibung());
            statement.setString(2, rcd.getMail());
            statement.setString(3, rcd.getHersteller());
            statement.setString(4, rcd.getBaujahr());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         
     }
      public boolean registerUser (RegisterUserDTO rud) {
         String sql = "insert into db.user values (?,?,?,?)";
         PreparedStatement statement = this.getPreparedStatement(sql);
     
        try {
            statement.setString(1, rud.getMail());
            statement.setString(2, rud.getPassword());
            statement.setString(3, rud.getVorname());
            statement.setString(4, rud.getName());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         
     }
}
