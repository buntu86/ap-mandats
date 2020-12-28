package ch.pillonel.mandats.model;

import ch.pillonel.mandats.Constants;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class Mandats {

    private List<Mandat> mandats = FXCollections.observableArrayList();

    public List<Mandat> getAll() {
        return mandats;
    }

    public List<Mandat> getActive() {
        return mandats.stream().filter(m -> m.getStatut().getStatut() == 0).collect(Collectors.toList());
    }

    public List<Mandat> getArchive(){
        return mandats.stream().filter(m -> m.getStatut().getStatut() == 1).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Mandats{" +
                "mandats=" + mandats +
                "\n}";
    }
}
