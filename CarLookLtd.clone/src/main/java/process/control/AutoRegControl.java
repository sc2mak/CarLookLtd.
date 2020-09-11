/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import model.dao.RegisterDAO;
import model.factory.RegisterFactory;
import model.object.dto.Auto;
import model.object.dto.RegisterCarDTO;
import model.object.dto.User;
import services.util.Roles;

/**
 *
 * @author thore
 */
public class AutoRegControl {
    private static AutoRegControl autoReg = null;
    
    public static AutoRegControl getInstance () {
        if (autoReg == null) {
            autoReg = new AutoRegControl();
        }
        return autoReg;
    }
    public boolean register (Auto auto) {
        User user = (User) UI.getCurrent().getSession().getAttribute(Roles.CURRENT_USER);
        RegisterCarDTO rcd = RegisterFactory.produceRegisterCarDTO(auto, user);
        boolean test = RegisterDAO.getInstance().registerAuto(rcd);    
        return test;
        }
    }

