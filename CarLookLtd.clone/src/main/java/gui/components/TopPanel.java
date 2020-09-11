/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.object.dto.Auto;
import model.object.dto.User;
import process.control.AutoAusgabe;
import static process.control.AutoAusgabe.list;
import process.control.LoginControll;
import process.controll.exceptions.DBFehler;
import process.controll.exceptions.SQLFehler;
import services.util.Roles;
import services.util.Views;

/**
 *
 * @author thore
 */
public class TopPanel extends HorizontalLayout{
    
    
    public TopPanel () {
        String name = null;
        User user = (User) UI.getCurrent().getSession().getAttribute(Roles.CURRENT_USER);
        if (user!= null) {
            name = user.getVorname();
        }
        Label welcome = new Label("Hallo " + name);
        this.addComponent(welcome);
        this.setComponentAlignment(welcome, Alignment.TOP_LEFT);
        MenuBar menuBar = new MenuBar();
        MenuItem item = menuBar.addItem ("Menü", null);
        item.addItem("Logout",FontAwesome.SIGN_OUT, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuItem selectedItem) {
                 LoginControll.logoutUser();
            }
        });
        item.addItem("Eingetragene Autos", FontAwesome.CAR, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuItem selectedItem) {
                try {
                    ArrayList <Auto> list = AutoAusgabe.getInstance().ausgabe();
               
                } catch (SQLFehler ex) {
                    Logger.getLogger(TopPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DBFehler ex) {
                    Notification.show("Fehler", ex.getGrund(), Notification.Type.ERROR_MESSAGE);;
                }
                VerticalLayout popupContent = new VerticalLayout();
                Grid<Auto> grid = new Grid<>(Auto.class);
                grid.setItems(list);
                popupContent.addComponent(grid);


                PopupView popup = new PopupView(null, popupContent);
                popup.setPopupVisible(true);
                addComponent(popup);
            }
        });
        this.addComponent(new Label ("<hr />", ContentMode.HTML));
        this.addComponent (menuBar);
        this.setComponentAlignment (menuBar, Alignment.MIDDLE_RIGHT);
        
    }
}
