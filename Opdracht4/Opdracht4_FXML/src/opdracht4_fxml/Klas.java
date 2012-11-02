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
public class Klas implements Serializable {
    private StringProperty klasNaam;
    private StringProperty klasNR;
    
    public Klas(){
    
    }
    
    public Klas(String naam, String nr){
        this.klasNaam = new SimpleStringProperty(naam);
        this.klasNR = new SimpleStringProperty(nr);
    }
    
    public StringProperty klasNaamProperty(){
        return this.klasNaam;
    }
    
    public StringProperty klasNRProperty(){
        return this.klasNR;
    }
}
