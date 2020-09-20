/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import process.controll.exceptions.DBFehler;
import services.db.JDBCcon;

/**
 *
 * @author thore
 */
public class AbstractDAO {
    
    protected Statement getStatement () {
        Statement statement = null;
        
        try {
            statement = JDBCcon.getInstance().getStatement();
        } catch (DBFehler ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }
    
    protected PreparedStatement getPreparedStatement (String sql) {
        
    PreparedStatement preparedStatement = null;
        
        try {
            preparedStatement = JDBCcon.getInstance().getPreparedStatement(sql);
        } catch (DBFehler ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preparedStatement;
    }
    
}
