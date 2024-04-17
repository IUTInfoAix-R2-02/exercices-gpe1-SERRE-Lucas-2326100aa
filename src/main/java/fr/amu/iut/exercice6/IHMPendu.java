package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class IHMPendu extends Application {

    private  int vie = 7;


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bdp = new BorderPane();
        VBox vbx1 = new VBox();
        vbx1.setAlignment(Pos.CENTER);

        //textfield
        TextField fieldName = new TextField("veuillez saisir une lettre");
        fieldName.setMaxWidth(180.0d);
        fieldName.setFont(Font.font("Courier",FontWeight.NORMAL, 12));

        //systeme de vie
        Button btnVal = new Button("Valider");
        Label vieNb = new Label("Vous avez encore " + vie +" vies");
        btnVal.addEventHandler(MouseEvent.MOUSE_CLICKED, valClicked -> {
            --vie;
            vieNb.setText( "Vous avez encore " + vie + " vies");
        });
        vbx1.getChildren().addAll(fieldName, btnVal, vieNb);

        //btn recommencer
        VBox vbxR = new VBox();
        Button btnR = new Button("Recommencer");
        btnR.addEventHandler(MouseEvent.MOUSE_CLICKED, rClicked -> {
            vie = 7;
            vieNb.setText( "Vous avez de nouveau " + vie + " vies");
        });
        vbxR.getChildren().add(btnR);
        vbxR.setAlignment(Pos.CENTER);

        Scene sc = new Scene(bdp);
        bdp.setCenter(vbx1);
        bdp.setBottom(vbxR);
        bdp.setStyle("-fx-background-color: #ff4343;");
        primaryStage.setScene(sc);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
