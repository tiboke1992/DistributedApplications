/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht4fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuBuilder;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;

/**
 *
 * @author stinson
 */
public class SampleController implements Initializable {
    
    @FXML
     public MenuBar menuB = new MenuBar();
    @FXML
    MenuItem menu111 = MenuItemBuilder.create().text("Nieuwe leerling").build();
    @FXML
    MenuItem menu112 = MenuItemBuilder.create().text("Nieuwe Klas").build();
    @FXML
    Menu menu11 = MenuBuilder.create().text("new").items(menu111,menu112).build();
    @FXML
    Menu menu1 = MenuBuilder.create().text("Options").items(menu11).build();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menuB.getMenus().addAll(menu1);
        menu111.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Geklikt op nieuw leerling");
            }
        });
        menu112.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Nieuwe klas");
            }
        });
    }    
}
