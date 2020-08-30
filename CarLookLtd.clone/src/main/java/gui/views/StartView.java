/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.views;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import gui.ui.MyUI;

/**
 *
 * @author thore
 */
public class StartView implements View{

    public void setUp() {
        final VerticalLayout layout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button loginbutton = new Button("login");
        loginbutton.addClickListener(e -> {
            layout.addComponent(new Label("login clilcked"));
        });
        Button registerbutton = new Button("register");
        registerbutton.addClickListener(e -> {
            layout.addComponent(new Label("register clilcked"));
        });
        horizontalLayout.addComponents(loginbutton, registerbutton);
        layout.addComponents(horizontalLayout);
        myUI.setContent(layout);
    }
    
}
