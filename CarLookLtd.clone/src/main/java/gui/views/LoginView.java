/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.object.dto.User;
import process.control.LoginControll;
import process.controll.exceptions.DBFehler;
import process.controll.exceptions.LoginDatenFehler;
import process.controll.exceptions.SQLFehler;
import services.util.Roles;
import services.util.Views;

/**
 *
 * @author thore
 */
public class LoginView extends VerticalLayout implements View{
    @Override 
    public void enter (ViewChangeListener.ViewChangeEvent event) {
        User user = (User) UI.getCurrent().getSession().getAttribute(Roles.CURRENT_USER);
        if (user != null) {
            UI.getCurrent().getNavigator().navigateTo(Views.MAIN);
        }
        else {
        this.setUp(); }
    }
     public void setUp() {
         Label head = new Label ("");
         final TextField login = new TextField();
         login.setCaption ("Username");
         final PasswordField password = new PasswordField ();
         password.setCaption("Password");
         
         HorizontalLayout layout = new HorizontalLayout();
         layout.addComponent(login);
         layout.addComponent(password);
         layout.addComponent(head);
         Panel panel = new Panel ("Bitte Nutzerdaten eingeben");
         this.addComponent(panel);
         this.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
         
         panel.setContent(layout);
         //this.addComponent(layout);
         
         Button loginButton = new Button ("Login");
         layout.addComponent(loginButton);
         loginButton.addClickListener(new Button.ClickListener() {
             @Override
             public void buttonClick(Button.ClickEvent event) {
                 String loginString = login.getValue();
                 String passwordString = password.getValue();
                 try {
                     LoginControll.check(loginString, passwordString);                  
                     
                 } catch (LoginDatenFehler ex) {
                     Notification.show("Fehler", "Logindaten falsch", Notification.Type.ERROR_MESSAGE);
                     login.setValue("");
                     password.setValue("");
                 }
                 catch (SQLFehler ex) {
                     Notification.show("Fehler", ex.getGrund(), Notification.Type.ERROR_MESSAGE);
                     login.setValue("");
                     password.setValue("");
                 }
                 catch (DBFehler ex) {
                     Notification.show("Fehler", ex.getGrund(), Notification.Type.ERROR_MESSAGE);
                     login.setValue("");
                     password.setValue("");
                 }
                 
             }
        } );
         
     
         
            
     }
}
