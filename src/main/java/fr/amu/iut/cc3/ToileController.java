package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }
    void tracePoint(double value, int axe){
        int x;
        int y;
        x=getXRadarChart(value,axe);
        y=getYRadarChart(value,axe);
        System.out.println(x);
        System.out.println(y);
    }
    @FXML
    TextField val1;
    String v1;
    @FXML
    TextField val2;
    String v2;
    @FXML
    TextField val3;
    String v3;
    @FXML
    TextField val4;
    String v4;
    @FXML
    TextField val5;
    String v5;
    @FXML
    TextField val6;
    String v6;

    @FXML
    private void Tracer(ActionEvent event){
        v1=val1.getText();
        v2=val2.getText();
        v3=val3.getText();
        v4=val4.getText();
        v5=val5.getText();
        v6=val6.getText();
        tracePoint(Integer.valueOf(v1),1);

    }

}
