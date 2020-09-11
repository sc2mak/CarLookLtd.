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
import com.vaadin.ui.VerticalLayout;
import process.control.LoginControll;
import process.control.RegisterControll;
import process.controll.exceptions.LoginDatenFehler;
import process.controll.exceptions.RegisterDatenFehler;

/**
 *
 * @author thore
 */
public class RegisterView extends VerticalLayout implements View{
     public void enter (ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
     public void setUp() {
         Label head = new Label ("Register");
         final TextField login = new TextField();
         login.setCaption ("Username");
         final PasswordField password = new PasswordField ();
         password.setCaption("Password");
         
         HorizontalLayout layout = new HorizontalLayout();
         layout.addComponent(login);
         layout.addComponent(password);
         Panel panel = new Panel ("Bitte Nutzerdaten eingeben");
         this.addComponent(panel);
         this.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
         panel.setContent(layout);
         //this.addComponent(layout);
         
         Button loginButton = new Button ("Register");
         layout.addComponent(loginButton);
         loginButton.addClickListener(new Button.ClickListener() {
             @Override
             public void buttonClick(Button.ClickEvent event) {
                 String loginString = login.getValue();
                 String passwordString = password.getValue();
                 
                 try {
                     RegisterControll.check(loginString, passwordString);
                 } catch (RegisterDatenFehler ex) {
                     Notification.show("Nutername bereits vorhanden", "Mail ist keine Firmenadresse", Notification.Type.ERROR_MESSAGE);
                     login.setValue("");
                     password.setValue("");
                 }
             }
        } );
     }
}
