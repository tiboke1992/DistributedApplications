/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstfxapplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author stinson
 */
public class MyFirstFXApplication extends Application {

    TextField getal1 = new TextField();
    TextField getal2 = new TextField();
    TextField uitkomst = new TextField();

    @Override
    public void start(Stage primaryStage) {
        BorderPane p = new BorderPane();

        //lings
        Label label1 = new Label("Getal 1 :");
        Label label2 = new Label("Getal 2 :");
        Label Label3 = new Label("Uitkomst : ");
        VBox left = new VBox();
        left.setSpacing(20);
        left.getChildren().addAll(label1, label2, Label3);
        p.setLeft(left);
        //center
        getal1 = new TextField();
        getal2 = new TextField();
        uitkomst = new TextField();
        Button optellen = new Button("+");
        telOp(optellen);
        Button aftrekken = new Button("-");
        aftrekken(aftrekken);
        uitkomst.setEditable(false);
        VBox center = new VBox();
        center.setSpacing(15);
        center.getChildren().addAll(getal1, getal2, uitkomst, optellen, aftrekken);
        p.setCenter(center);

        primaryStage.setScene(new Scene(p, 300, 200));
        primaryStage.setTitle("MiniCalculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void telOp(Button optellen) {
        optellen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (controleer()) {
                    Double tGetal1 = Double.parseDouble(getal1.getText());
                    Double tGetal2 = Double.parseDouble(getal2.getText());
                    Double tUitkomst = tGetal1 + tGetal2;
                    uitkomst.setText("" + tUitkomst);
                }
            }
        });
    }

    private void aftrekken(Button aftrekken) {
        aftrekken.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (controleer()) {
                    Double tGetal1 = Double.parseDouble(getal1.getText());
                    Double tGetal2 = Double.parseDouble(getal2.getText());
                    Double tUitkomst = tGetal1 - tGetal2;
                    uitkomst.setText("" + tUitkomst);
                }
            }
        });
    }

    private boolean controleer() {
        boolean result = false;
        try {
            Double tGetal1 = Double.parseDouble(getal1.getText());
            Double tGetal2 = Double.parseDouble(getal2.getText());
            result = true;
            uitkomst.setStyle("-fx-text-fill: green");
        } catch (NumberFormatException e) {
            uitkomst.setText("alleen getallen invullen!");
            uitkomst.setStyle("-fx-text-fill: red");
        }
        return result;
    }
}
