/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import process.controll.exceptions.DBFehler;

/**
 *
 * @author thore
 */
public class JDBCcon {
    
    private static JDBCcon con = null;
    private static String login = "treime2s";
    private static String password = "treime2s";
    private static String url = "jdbc:postgresql://dumbo.inf.h-brs.de/treime2s";
    private Connection conn;
    public static JDBCcon getInstance () throws DBFehler{
          if (con == null) {
              con = new JDBCcon();
          }
          return con;
    }
    
    private JDBCcon () throws DBFehler{
        this.init();
    }
    
    public void init() throws DBFehler {
        try {
            DriverManager.registerDriver( new org.postgresql.Driver() );
        } catch (SQLException ex) {
            Logger.getLogger(JDBCcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.open();
    }
    public void open () throws DBFehler {
                Properties props = new Properties();
                props.setProperty("user",this.login);
                props.setProperty("password",this.password);
                try {
                    this.conn = DriverManager.getConnection(this.url, props);
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCcon.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DBFehler ("Fehler im Verbindngsaufbau zur Datenbank - vpn prüfen");
                }
               
    }
        public Statement getStatement () throws DBFehler{
            
        
        try {
            if (this.conn.isClosed()) {
                this.open();
            }
           return this.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCcon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        public void close () {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public PreparedStatement getPreparedStatement (String sql) throws DBFehler {
            try {
            if (this.conn.isClosed()) {
                this.open();
            }
           return this.conn.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCcon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        
        }
}
}

