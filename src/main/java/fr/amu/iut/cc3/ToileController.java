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
import javafx.scene.control.Label;
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
    void moveLine(Line l,Circle cd,Circle cf){
        l.setStartX(cd.getCenterX());
        l.setStartY(cd.getCenterY());
        l.setEndX(cf.getCenterX());
        l.setEndY(cf.getCenterY());
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
    int v1;
    @FXML
    TextField val2;
    int v2;
    @FXML
    TextField val3;
    int v3;
    @FXML
    TextField val4;
    int v4;
    @FXML
    TextField val5;
    int v5;
    @FXML
    TextField val6;
    int v6;
    @FXML
    Label error;

    boolean p1 = false;
    boolean p2 = false;
    boolean p3 = false;
    boolean p4 = false;
    boolean p5 = false;
    boolean p6 = false;
    @FXML
    Line line1 ;
    @FXML
    Line line2 ;
    @FXML
    Line line3 ;
    @FXML
    Line line4 ;
    @FXML
    Line line5 ;
    @FXML
    Line line6 ;

    @FXML
    private void placerPoints(ActionEvent event){
        v1=Integer.valueOf(val1.getText());
        v2=Integer.valueOf(val2.getText());
        v3=Integer.valueOf(val3.getText());
        v4=Integer.valueOf(val4.getText());
        v5=Integer.valueOf(val5.getText());
        v6=Integer.valueOf(val6.getText());
        if (v1 > 0 && v1 <= 20){
            calcPosPoint(Integer.valueOf(v1),1,c1);
            p1 = true;
        }
        else error.setVisible(true);
        if (v2 > 0 && v2 <= 20){
            calcPosPoint(Integer.valueOf(v2),2,c2);
            p2 = true;
        }
        else error.setVisible(true);
        if (v3 > 0 && v3 <= 20) {
            calcPosPoint(Integer.valueOf(v3), 3, c3);
            p3 = true;
        }
        else error.setVisible(true);
        if (v4 > 0 && v4 <= 20) {
            calcPosPoint(Integer.valueOf(v4), 4, c4);
            p4 = true;

        }
        else error.setVisible(true);
        if (v5 > 0 && v5 <= 20){
            calcPosPoint(Integer.valueOf(v5),5,c5);
            p5 = true;
        }
        else error.setVisible(true);
        if (v6 > 0 && v6 <= 20){
            calcPosPoint(Integer.valueOf(v6),6,c6);
            p6 = true;
        }
        else error.setVisible(true);

    }
    @FXML
    private void tracer(ActionEvent e){
        moveLine(line1,c1,c2);
        moveLine(line2,c2,c3);
        moveLine(line3,c3,c4);
        moveLine(line4,c4,c5);
        moveLine(line5,c5,c6);
        moveLine(line6,c6,c1);

    }
    @FXML
    private void vider(ActionEvent e){
        changePosPoint(originX,originY,c1);
        changePosPoint(originX,originY,c2);
        changePosPoint(originX,originY,c3);
        changePosPoint(originX,originY,c4);
        changePosPoint(originX,originY,c5);
        changePosPoint(originX,originY,c6);
        moveLine(line1,c1,c2);
        moveLine(line2,c1,c2);
        moveLine(line3,c1,c2);
        moveLine(line4,c1,c2);
        moveLine(line5,c1,c2);
        moveLine(line6,c1,c2);
        p1 = false;
        p2 = false;
        p3 = false;
        p4 = false;
        p5 = false;
        p6 = false;
        error.setVisible(false);

    }
}
