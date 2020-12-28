package ch.pillonel.mandats.view;

import ch.pillonel.mandats.Constants;
import ch.pillonel.mandats.model.Mandat;
import ch.pillonel.tools.Convertion;
import ch.pillonel.tools.Msg;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class LeftPaneController implements Initializable {

    @FXML private ListView<Mandat> listView;
    @FXML private CheckBox checkBoxActive, checkBoxArchive;
    @FXML private TextField textFieldSearch;
    @FXML private Label lb_nbrFilter, lb_nbrTotal;
    @FXML private Button bt_clear;

    private RightPaneController rightPane;

    private static ListCell<Mandat> call(ListView<Mandat> list) {
        return new ListCell<Mandat>() {
            @Override
            protected void updateItem(Mandat item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty)
                    setText(null);
                else
                    setText(item.getNumMandat() + " - " + item.getNomMandat() + " " + item.getStatut().toStringForList());
            }
        };
    }

    @FXML private void openUrl(){
        if(listView.getItems().size()>0 && listView.getFocusModel().getFocusedIndex()>=0) {
            Mandat newValue = listView.getFocusModel().getFocusedItem();

            File file = new File(newValue.getUrl());
            Msg.info("open url -> " + newValue.getUrl());
            if(file.isDirectory()){
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                }
            }
        }
    }

    private void mandateSelected(Mandat newValue) {
        if(newValue!=null)
            rightPane.setMandatSelected(newValue);
    }

    public void update(){
        Boolean active = checkBoxActive.isSelected(), archive = checkBoxArchive.isSelected();
        String search = textFieldSearch.getText();
        List<Mandat> list = new ArrayList<>();

        if(active)
            if(archive)
                list = Constants.getMandatsData().getAll();
            else
                list = Constants.getMandatsData().getActive();
        else
            if(archive)
                list = Constants.getMandatsData().getArchive();

        list = list.stream().filter(l -> l.getNumMandat().concat(l.getNomMandat()).toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());

        listView.setItems(FXCollections.observableArrayList(list));
        if (!listView.getItems().isEmpty()) {
            listView.getSelectionModel().select(0);
        }
        setLabel();

        if(textFieldSearch.getText().equals(""))
            clearTextField();
    }

    public void setRightPane(RightPaneController rightPane){
        this.rightPane = rightPane;
    }

    public void clearTextField(){
        textFieldSearch.clear();
        listView.getSelectionModel().clearSelection();
        this.rightPane.clear();
    }

    public void setLabel(){
        int sizeTotal = 0;

        if(checkBoxArchive.isSelected())
            sizeTotal = sizeTotal + Constants.getMandatsData().getArchive().size();
        if(checkBoxActive.isSelected())
            sizeTotal = sizeTotal + Constants.getMandatsData().getActive().size();

        lb_nbrTotal.setText(Convertion.intToString(sizeTotal));
        lb_nbrFilter.setText(Convertion.intToString(listView.getItems().size()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Set cell of listView
        listView.setItems(FXCollections.observableArrayList(Constants.getMandatsData().getAll()));
        listView.setCellFactory(LeftPaneController::call);

        //Set leftPane on Constants
        Constants.setLeftPane(this);

        //Set on mouse clicked
        listView.setOnMouseClicked(click -> {
            if (click.getClickCount() == 2) {
                openUrl();
            }
        });

        //Set checkBoxArchive false
        checkBoxArchive.setSelected(false);

        //Listeners
        checkBoxActive.selectedProperty().addListener(((observable, oldValue, newValue) -> update()));
        checkBoxArchive.selectedProperty().addListener(((observable, oldValue, newValue) -> update()));
        textFieldSearch.textProperty().addListener(((observable, oldValue, newValue) -> update()));
        listView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> mandateSelected(newValue)));

        textFieldSearch.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.DOWN && listView.getItems().size() >= 1)
                listView.getSelectionModel().select(listView.getSelectionModel().getSelectedIndex()+1);
            if (event.getCode() == KeyCode.UP && listView.getItems().size() >= 1)
                listView.getSelectionModel().select(listView.getSelectionModel().getSelectedIndex()-1);

        });
    }
}
