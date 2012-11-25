/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

/**
 *
 * @author stinson
 */
public class Opdracht8FXMLController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField lengte;
    @FXML
    private TextField gewicht;
    @FXML
    private CheckBox man;
    @FXML
    private CheckBox vrouw;
    @FXML
    private TextField bmi;
    @FXML
    private Slider slider;
    @FXML
    private TextField sliderValue;
    @FXML
    private TextArea areaMan;
    @FXML
    private TextArea areaVrouw;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        areaMan.setVisible(false);
        areaVrouw.setVisible(false);
        areaMan.visibleProperty().bind(man.selectedProperty());
        areaVrouw.visibleProperty().bind(vrouw.selectedProperty());
        areaMan.setEditable(false);
        areaVrouw.setEditable(false);
        slider.setMax(200);
        slider.setMin(1);
        lengte.prefWidthProperty().bind(slider.valueProperty());
        gewicht.prefWidthProperty().bind(slider.valueProperty());
        bmi.prefWidthProperty().bind(slider.valueProperty());
        sliderValue.setText("" + slider.getValue());
        sliderValue.textProperty().bindBidirectional(slider.valueProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number t) {
                Integer r = t.intValue();
                return r.toString();
            }

            @Override
            public Number fromString(String string) {
                return Double.parseDouble(string);
            }
        });
      

        ChangeListener observerA = new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                if (isNumeric(lengte.getText()) && isNumeric(gewicht.getText())) {
                    bmi.setText("" + (int) (Integer.parseInt(gewicht.getText()) / Math.pow(Double.parseDouble(lengte.getText()), 2)));
                    bereken();
                }
            }
        };
        lengte.textProperty().addListener(observerA);
        gewicht.textProperty().addListener(observerA);

    }

    public boolean isNumeric(String str) {
        boolean result = false;
        try {
            Double d = Double.parseDouble(str);
            if (d > 0) {
                result = true;
            }
        } catch (NumberFormatException fout) {
        }
        return result;
    }

    public void bereken() {
        areaMan.setText("Mannen berekenen geen BMI");
        int s = Integer.parseInt(bmi.getText());
        if (s > 18 && s < 25) {
            areaVrouw.setText("Normaal");
        } else if (s < 18) {
            areaVrouw.setText("Ondergewicht");
        } else {
            areaVrouw.setText("Overgewicht");
        }
    }
}
