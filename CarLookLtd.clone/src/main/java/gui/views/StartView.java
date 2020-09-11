/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import gui.ui.MyUI;
import services.util.Views;

/**
 *
 * @author thore
 */
public class StartView extends VerticalLayout implements View{
    public void enter (ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
    public void setUp() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button loginButton = new Button("login");
        loginButton.addClickListener(e -> {
           UI.getCurrent().getNavigator().navigateTo(Views.LOGIN);
        });
        Button registerButton = new Button("register");
        registerButton.addClickListener(e -> {
            UI.getCurrent().getNavigator().navigateTo(Views.REGISTER);;
        });
        horizontalLayout.addComponents(loginButton, registerButton);
        addComponents(horizontalLayout);
        
        loginButton.addClickListener(new Button.ClickListener() {
             @Override
             public void buttonClick(Button.ClickEvent event) {
                 
             }
        } );
        
    }
    
}
