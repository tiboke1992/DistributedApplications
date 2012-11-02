/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht4_fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 *
 * @author stinson
 */
public class FXMLFileController implements Initializable {

    @FXML
    static MenuBar menuBar = new MenuBar();
    @FXML
    static Pane pane1 = new Pane();
    @FXML
    static Pane pane2 = new Pane();
    @FXML
    TextField lNaam = new TextField();
    @FXML
    TextField lVoornaam = new TextField();
    @FXML
    TextField lKlas = new TextField();
    @FXML
    Button lSave = new Button();
    @FXML
    TextField kNaam = new TextField();
    @FXML
    TextField kNr = new TextField();
    @FXML
    Button kSave = new Button();
    @FXML
    RadioButton man = new RadioButton();
    @FXML
    RadioButton vrouw = new RadioButton();
    @FXML
    Pane pane11 = new Pane();
    @FXML
    TableView lTable = new TableView();
    @FXML
    TableView kTable = new TableView();
    @FXML
    Tab tabLeerling = new Tab();
    @FXML
    Tab tabKlassen = new Tab();
    ObservableList<Klas> klasData;
    ObservableList<Person> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        menuBar.getMenus().clear();
        Menu file = new Menu("File");
        Menu edit = new Menu("Overview");
        Menu nieuw = new Menu("New");
        MenuItem close = new MenuItem("Close");
        MenuItem view = new MenuItem("Show");
        edit.getItems().add(view);
        file.getItems().addAll(nieuw, close);
        MenuItem nKlas = new MenuItem("Nieuwe klas");
        MenuItem nLeerling = new MenuItem("Nieuwe Leerling");
        nieuw.getItems().addAll(nKlas, nLeerling);
        menuBar.getMenus().addAll(file, edit);
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane11.setVisible(false);
        //methods
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        nKlas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pane2.setVisible(true);
                pane1.setVisible(false);
                pane11.setVisible(false);
            }
        });
        nLeerling.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pane1.setVisible(true);
                pane2.setVisible(false);
                pane11.setVisible(false);
            }
        });
        man.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                vrouw.setSelected(false);
            }
        });
        vrouw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                man.setSelected(false);
            }
        });
        view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pane11.setVisible(true);
                pane1.setVisible(false);
                pane2.setVisible(false);
            }
        });
        //tabel invullen
        data = FXCollections.observableArrayList(
                new Person("Hulens", "Tibo", "320"),
                new Person("Vanwyngaerden", "Tom", "320"),
                new Person("Dens", "Adriaan", "210"));
        TableColumn tableNaam = new TableColumn();
        tableNaam.setText("Naam");
        tableNaam.setCellValueFactory(new PropertyValueFactory("naam"));
        TableColumn tableVN = new TableColumn();
        tableVN.setText("Voornaam");
        tableVN.setCellValueFactory(new PropertyValueFactory("voornaam"));
        TableColumn tableNR = new TableColumn();
        tableNR.setText("Klas nr");
        tableNR.setCellValueFactory(new PropertyValueFactory("klasnr"));
        lTable.setItems(data);
        lTable.getColumns().clear();
        lTable.getColumns().add(tableNaam);
        lTable.getColumns().add(tableVN);
        lTable.getColumns().add(tableNR);
        //Tabel 2 invullen
        klasData = FXCollections.observableArrayList(new Klas("Superklas", "2TX"), new Klas("Niet zo super", "Alle rest"), new Klas("Mega mindi klas", "220"));
        TableColumn klasNaam = new TableColumn();
        klasNaam.setText("KlasNaam");
        klasNaam.setCellValueFactory(new PropertyValueFactory("klasNaam"));
        TableColumn klasNR = new TableColumn();
        klasNR.setText("Klas-NR");
        klasNR.setCellValueFactory(new PropertyValueFactory("klasNR"));
        kTable.setItems(klasData);
        kTable.getColumns().clear();
        kTable.getColumns().addAll(klasNaam, klasNR);

        //Save dingen
        kSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                klasData.add(new Klas(kNaam.getText(),kNr.getText()));
                kNaam.setText("");
                kNr.setText("");
            }
        });
        lSave.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String geslacht = (man.isSelected())?"M":"V"; 
                data.add(new Person(lNaam.getText(), geslacht + "_" + lVoornaam.getText(), lKlas.getText()));
                lNaam.clear();
                lVoornaam.clear();
                lKlas.clear();
                vrouw.setSelected(false);
                man.setSelected(false);
            }
        });
    }
}
