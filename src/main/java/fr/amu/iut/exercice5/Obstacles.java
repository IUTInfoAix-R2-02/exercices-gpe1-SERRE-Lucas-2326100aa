package fr.amu.iut.exercice5;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Obstacles extends Rectangle {

    public Obstacles (double X, double Y, double width, double height){
    super(X, Y, width, height);
    setFill(Color.RED);
    }
}
