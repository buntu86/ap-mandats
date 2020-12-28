package ch.pillonel.mandats;

import ch.pillonel.mandats.view.LeftPaneController;
import ch.pillonel.mandats.view.MainViewController;
import ch.pillonel.tools.Msg;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception{

        FXMLLoader rootLoader = new FXMLLoader();
        rootLoader.setLocation(getClass().getResource("view/MainView.fxml"));
        Parent root = rootLoader.load();

        primaryStage.setTitle("AP - Mandats");
        primaryStage.setScene(new Scene(root, 800, 450));
        primaryStage.show();

        root.getScene().addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.F12) {
                Msg.saveMsg();
            }

            if(event.getCode() == KeyCode.ESCAPE && Constants.getLeftPane() != null)
                Constants.getLeftPane().clearTextField();
        });

        Constants.iniMandatsData();
        Constants.getLeftPane().update();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//https://o7planning.org/fr/11009/javafx
//http://tutorials.jenkov.com/javafx/fxml.html