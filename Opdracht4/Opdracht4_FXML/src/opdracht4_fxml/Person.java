/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht4_fxml;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author stinson
 */
public class Person implements Serializable {

    private StringProperty naam;
    private StringProperty voornaam;
    private StringProperty klasnr;

    public Person() {
        this(null,null,null);
    }

    public Person(String naam, String vNaam, String klasnr) {
        this.naam = new SimpleStringProperty(naam);
        this.voornaam = new SimpleStringProperty(vNaam);
        this.klasnr = new SimpleStringProperty(klasnr);
    }

    public StringProperty naamProperty() {
        return naam;
    }

    public StringProperty voornaamProperty() {
        return voornaam;
    }

    public StringProperty klasnrProperty() {
        return klasnr;
    }
}
