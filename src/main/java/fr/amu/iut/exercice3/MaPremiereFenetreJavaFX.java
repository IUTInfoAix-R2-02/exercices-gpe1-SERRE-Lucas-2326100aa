package fr.amu.iut.exercice3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;

public class MaPremiereFenetreJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //vbox
        VBox vbx1 = new VBox();
        vbx1.setAlignment(CENTER);

        //creation du label et ajout a la vbox
        Label labelHello = new Label("Bonjour");
        vbx1.getChildren().add(labelHello);

        //ajout d'un champ
        TextField fieldName = new TextField("veuillez saisir votre nom");
        fieldName.setMaxWidth(180.0d);
        fieldName.setFont(Font.font("Courier",FontWeight.NORMAL, 12));
        vbx1.getChildren().add(fieldName);

        //ajout d'un bouton
        Button btnHello = new Button("dire bonjour");
        vbx1.getChildren().add(btnHello);

        // Changement du texte après un clic sur le bouton
        btnHello.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            labelHello.setText( "Bonjour à toi, "+fieldName.getText() );
        });

        //details de la page
        Scene scene = new Scene(vbx1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("La page d'un Pro de JavaFX");
        primaryStage.setHeight(400);
        primaryStage.setWidth(400);
        primaryStage.show();
    }
}
