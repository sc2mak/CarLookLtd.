/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.ContentMode;
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
import gui.components.TopPanel;
import model.object.dto.Auto;
import model.object.dto.User;
import process.control.AutoRegControl;
import process.control.RegisterControll;
import process.controll.exceptions.RegisterDatenFehler;
import services.util.Roles;
import services.util.Views;

/**
 *
 * @author thore
 */
public class MainView extends VerticalLayout implements View{
    public void enter (ViewChangeListener.ViewChangeEvent event) {
        
        User user = (User) UI.getCurrent().getSession().getAttribute(Roles.CURRENT_USER);
        if (user == null) {
            UI.getCurrent().getNavigator().navigateTo(Views.LOGIN);
        }
        
        this.setUp();
    }
     public void setUp() {
         this.addComponent(new TopPanel ());
         
         setMargin(true);
         
         final TextField beschreibung = new TextField();
         beschreibung.setCaption("beschreibung");
         final TextField marke = new TextField();
         marke.setCaption("marke");
         final TextField baujahr = new TextField();
         baujahr.setCaption("baujahr");
         
         this.addComponent(beschreibung);
         this.addComponent(marke);
         this.addComponent(baujahr);
         
         Button registerButton = new Button ("Register Auto");
         this.addComponent(registerButton);
         registerButton.addClickListener(new Button.ClickListener() {
             @Override
             public void buttonClick(Button.ClickEvent event) {
                 Auto auto = new Auto (beschreibung.getValue(), marke.getValue(), baujahr.getValue());
                 boolean test = AutoRegControl.getInstance().register(auto);
                 if (test) { Notification.show("Ok", "Registrierung erfolgreich!", Notification.Type.HUMANIZED_MESSAGE);
                 }
                 else {
                     Notification.show("Fehler", "fehler", Notification.Type.ERROR_MESSAGE);
                 }
             }
         });
         
     }
}
