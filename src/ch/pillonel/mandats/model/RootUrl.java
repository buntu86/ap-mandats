package ch.pillonel.mandats.model;

import ch.pillonel.tools.Convertion;

public class RootUrl {
    private String url = "";
    private Statut statut = new Statut();

    public RootUrl(String str){
        // --EXAMPLE--
        // 0,C:\\Temp\\AP_Mandats\\Projects active;

        if(str.length()>0){
            statut = new Statut(Convertion.stringToInteger(str.substring(0,1)));

            int start = str.indexOf(",");
            int end = str.indexOf(";");

            if(start > 0 && end > start)
                url = str.substring(start + 1 , end);
        }
    }

    public String getUrl(){
        return url;
    }
    public Statut getStatus(){
        return statut;
    }

    @Override public String toString(){
        return url + " | " + statut;
    }
}
