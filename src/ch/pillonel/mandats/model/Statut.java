package ch.pillonel.mandats.model;

public class Statut {

    //actif = 0
    //archive = 1

    private int statut;

    public Statut(int statut) {
        setStatut(statut);
    }

    public Statut(){
        setStatut(0);
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        if(statut == 0)
            this.statut = statut;
        else
            this.statut = 1;
    }

    public String toStringForShow(){
        String tmp = "actif";
        if(statut == 1)
            tmp = "archivé";

        return tmp;
    }

    public String toStringForList() {
        String tmp = "";
        if(statut == 1)
            tmp = " [A]";

        return tmp;
    }

    @Override public String toString(){
        return toStringForShow();
    }
}
