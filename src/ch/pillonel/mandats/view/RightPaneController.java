package ch.pillonel.mandats.view;

import ch.pillonel.mandats.model.Mandat;
import ch.pillonel.tools.Msg;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RightPaneController {

    //https://rterp.wordpress.com/2014/04/25/gmapsfx-add-google-maps-to-your-javafx-application/
    //https://api3.geo.admin.ch/index.html

    @FXML Label lbNumMandat, lbNomMandat, lbStatut;
    @FXML Hyperlink url;
    @FXML ScrollPane scrollPane;
    @FXML HBox hbox;

    @FXML
    private void initialize() {
    }

    public void setMandatSelected(Mandat newValue) {
        lbNomMandat.setText(newValue.getNomMandat());
        lbNumMandat.setText(newValue.getNumMandat());
        lbStatut.setText(newValue.getStatut().toStringForShow());

        //--- URL ---
        url.setDisable(false);
        url.setStyle("-fx-text-fill: #6699ff;");

            //Hyperlink to url
            File file = new File(newValue.getUrl());
            url.setText(newValue.getUrl());
            if(file.isDirectory()){
                url.setOnAction(event -> {
                    try {
                        if(file.isDirectory())
                            Desktop.getDesktop().open(file);
                        else
                            Msg.error("Dossier '" + file + "' n'existe plus.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            else{
                url.setStyle("-fx-text-fill: red;");
                url.setDisable(true);
            }
        hbox.setVisible(false);
        scrollPane.setVisible(true);
    }

    public void clear() {
        lbNomMandat.setText("");
        lbNumMandat.setText("");
        lbStatut.setText("");
        url.setText("");
        hbox.setVisible(true);
        scrollPane.setVisible(false);
    }
}
