package ch.pillonel.mandats.view;

import ch.pillonel.mandats.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML SplitPane splitPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FXMLLoader loaderLeft = new FXMLLoader();
            loaderLeft.setLocation(Main.class.getResource("view/LeftPane.fxml"));
            AnchorPane left = loaderLeft.load();
            LeftPaneController controllerLeft = loaderLeft.getController();

            FXMLLoader loaderRight = new FXMLLoader();
            loaderRight.setLocation(Main.class.getResource("view/RightPane.fxml"));
            AnchorPane right = loaderRight.load();
            RightPaneController controllerRight = loaderRight.getController();
            controllerLeft.setRightPane(controllerRight);

            splitPane.getItems().addAll(left, right);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
