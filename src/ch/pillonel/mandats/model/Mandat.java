package ch.pillonel.mandats.model;

import javafx.beans.property.*;

public class Mandat {

    private StringProperty numMandat, nomMandat, url, dess, ing, ent;
    private ObjectProperty<Statut> statut;
    private IntegerProperty dateDebut, dateFin, coordonneeX, coordonneeY;

    public Mandat(StringProperty numMandat, StringProperty nomMandat, StringProperty url, ObjectProperty<Statut> statut) {
        this.numMandat = numMandat;
        this.nomMandat = nomMandat;
        this.url = url;
        this.statut = statut;
        this.dess = new SimpleStringProperty("---");
        this.ing = new SimpleStringProperty("---");
        this.ent = new SimpleStringProperty("---");
        this.dateDebut = new SimpleIntegerProperty(0);
        this.dateFin = new SimpleIntegerProperty(0);
        this.coordonneeX = new SimpleIntegerProperty(0);
        this.coordonneeY = new SimpleIntegerProperty(0);
    }

    public Mandat(String numMandat, String nomMandat, String url, int statut) {
        this.numMandat = new SimpleStringProperty(numMandat);
        this.nomMandat = new SimpleStringProperty(nomMandat);
        this.url = new SimpleStringProperty(url);
        this.statut = new SimpleObjectProperty<Statut>(new Statut(statut));
        this.dess = new SimpleStringProperty("---");
        this.ing = new SimpleStringProperty("---");
        this.ent = new SimpleStringProperty("---");
        this.dateDebut = new SimpleIntegerProperty(0);
        this.dateFin = new SimpleIntegerProperty(0);
        this.coordonneeX = new SimpleIntegerProperty(0);
        this.coordonneeY = new SimpleIntegerProperty(0);
    }

    public Mandat(){
        this("000", "", "", 0);
    }

    public String getNumMandat() {
        return numMandat.get();
    }

    public StringProperty numMandatProperty() {
        return numMandat;
    }

    public void setNumMandat(String numMandat) {
        this.numMandat.set(numMandat);
    }

    public String getNomMandat() {
        return nomMandat.get();
    }

    public StringProperty nomMandatProperty() {
        return nomMandat;
    }

    public void setNomMandat(String nomMandat) {
        this.nomMandat.set(nomMandat);
    }

    public String getUrl() {
        return url.get();
    }

    public StringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public String getDess() {
        return dess.get();
    }

    public StringProperty dessProperty() {
        return dess;
    }

    public void setDess(String dess) {
        this.dess.set(dess);
    }

    public String getIng() {
        return ing.get();
    }

    public StringProperty ingProperty() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing.set(ing);
    }

    public String getEnt() {
        return ent.get();
    }

    public StringProperty entProperty() {
        return ent;
    }

    public void setEnt(String ent) {
        this.ent.set(ent);
    }

    public Statut getStatut() {
        return statut.get();
    }

    public ObjectProperty<Statut> statutProperty() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut.set(statut);
    }

    public int getDateDebut() {
        return dateDebut.get();
    }

    public IntegerProperty dateDebutProperty() {
        return dateDebut;
    }

    public void setDateDebut(int dateDebut) {
        this.dateDebut.set(dateDebut);
    }

    public int getDateFin() {
        return dateFin.get();
    }

    public IntegerProperty dateFinProperty() {
        return dateFin;
    }

    public void setDateFin(int dateFin) {
        this.dateFin.set(dateFin);
    }

    public int getCoordonneeX() {
        return coordonneeX.get();
    }

    public IntegerProperty coordonneeXProperty() {
        return coordonneeX;
    }

    public void setCoordonneeX(int coordonneeX) {
        this.coordonneeX.set(coordonneeX);
    }

    public int getCoordonneeY() {
        return coordonneeY.get();
    }

    public IntegerProperty coordonneeYProperty() {
        return coordonneeY;
    }

    public void setCoordonneeY(int coordonneeY) {
        this.coordonneeY.set(coordonneeY);
    }

    @Override
    public String toString() {
        return "\n\tMandat{" +
                "numMandat=" + numMandat +
                ", nomMandat=" + nomMandat +
                ", url=" + url +
                ", dess=" + dess +
                ", ing=" + ing +
                ", ent=" + ent +
                ", statut=" + statut +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", coordonneeX=" + coordonneeX +
                ", coordonneeY=" + coordonneeY +
                "}";
    }
}
