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
import javafx.scene.shape.Circle;
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
    private static int originX = 200;
    private static int originY = 200;


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
    void changePosPoint(int x, int y ,Circle c){
        c.setCenterX(x);
        c.setCenterY(y);
    }
    void calcPosPoint(double value, int axe, Circle c){
        int x;
        int y;
        x=getXRadarChart(value,axe);
        y=getYRadarChart(value,axe);
        changePosPoint(x,y,c);
    }
    @FXML
    Circle c1;
    @FXML
    Circle c2;
    @FXML
    Circle c3;
    @FXML
    Circle c4;
    @FXML
    Circle c5;
    @FXML
    Circle c6;
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
    private void tracer(ActionEvent event){
        v1=val1.getText();
        v2=val2.getText();
        v3=val3.getText();
        v4=val4.getText();
        v5=val5.getText();
        v6=val6.getText();
        if (v1 !=""){calcPosPoint(Integer.valueOf(v1),1,c1);}
        if (v2 !=""){calcPosPoint(Integer.valueOf(v2),2,c2);}
        if (v3 !="")calcPosPoint(Integer.valueOf(v3),3,c3);
        if (v4 !="")calcPosPoint(Integer.valueOf(v4),4,c4);
        if (v5 !="")calcPosPoint(Integer.valueOf(v5),5,c5);
        if (v6 !="")calcPosPoint(Integer.valueOf(v6),6,c6);

    }
    @FXML
    private void vider(ActionEvent e){
        // changer la value des coord de tt les points en l'origine cad 200 200

        changePosPoint(originX,originY,c1);
        changePosPoint(originX,originY,c2);
        changePosPoint(originX,originY,c3);
        changePosPoint(originX,originY,c4);
        changePosPoint(originX,originY,c5);
        changePosPoint(originX,originY,c6);

    }
}
