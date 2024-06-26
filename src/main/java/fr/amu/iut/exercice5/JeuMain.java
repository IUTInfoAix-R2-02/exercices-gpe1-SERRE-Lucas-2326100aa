package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        //obstacles
        List<Obstacles> obs = new ArrayList<>();
        Obstacles obs1 = new Obstacles(50, 90, 40, 40);
        Obstacles obs2 = new Obstacles(300, 250, 80, 80);
        Obstacles obs3 = new Obstacles(330, 100, 100, 20);

        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().addAll(obs1, obs2, obs3);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    j1.getLayoutX();
                    j1.getLayoutY();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    j1.getLayoutX();
                    j1.getLayoutY();
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    j1.getLayoutX();
                    j1.getLayoutY();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    j1.getLayoutX();
                    j1.getLayoutY();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    j2.getLayoutX();
                    j2.getLayoutY();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    j2.getLayoutX();
                    j2.getLayoutY();
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    j2.getLayoutX();
                    j2.getLayoutY();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    j2.getLayoutX();
                    j2.getLayoutY();
                    break;

            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                System.exit(0);
            }

        });
    }


}
