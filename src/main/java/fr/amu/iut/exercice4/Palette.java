package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bdp = new BorderPane();

        //zone bouton
        HBox hbxBtn = new HBox();
        hbxBtn.setAlignment(CENTER);
        vert = new Button("Vert");
        rouge = new Button ("Rouge");
        bleu = new Button("Bleu");
        hbxBtn.getChildren().addAll(vert, rouge, bleu);
        bdp.setBottom(hbxBtn);

        //pane
        Pane pn = new Pane();
        bdp.setCenter(pn);

        //label affichage de la phrase d'entete + compte
        HBox hbxLbl = new HBox();
        bdp.setTop(hbxLbl);
        hbxLbl.setAlignment(CENTER);
        Label labelHello = new Label("Choisissez une couleur");
        hbxLbl.getChildren().add(labelHello);

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, vertClicked -> {
            nbVert++;
            pn.setStyle("-fx-background-color: green");
            labelHello.setText( "vert choisi "+nbVert+"fois");
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, rougeClicked -> {
            nbRouge++;
            pn.setStyle("-fx-background-color: red");
            labelHello.setText( "vert choisi "+nbRouge+"fois");
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, bleuCliked -> {
            nbBleu++;
            pn.setStyle("-fx-background-color: blue");
            labelHello.setText( "vert choisi "+nbBleu+"fois");
        });

        //details de la page
        Scene sc = new Scene(bdp,400, 200);
        primaryStage.setScene((sc));
        primaryStage.show();
    }
}

