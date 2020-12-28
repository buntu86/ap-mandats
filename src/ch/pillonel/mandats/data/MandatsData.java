package ch.pillonel.mandats.data;

import ch.pillonel.mandats.Constants;
import ch.pillonel.mandats.model.Mandat;
import ch.pillonel.mandats.model.Mandats;
import ch.pillonel.mandats.model.RootUrl;
import ch.pillonel.tools.Msg;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;

public class MandatsData {

    private static Mandats mandats = new Mandats();

    public MandatsData() {
    }

    public static Mandats loadData(){
        MandatsData.mandats.getAll().clear();

        //0,C:\\Temp\\AP_Mandats\\Projets en cours;
        for (RootUrl rootUrl : Constants.getRootUrlActif()) {
            File dir = new File(rootUrl.getUrl());
            if (dir.isDirectory()) {
                for (File f : dir.listFiles())
                    MandatsData.addMandat(f, 0);
                Msg.info("OK Dossier 'actif' => " + rootUrl);
            } else
                Msg.error("Dossier 'actif', n'existe pas. => " + rootUrl);
        }

        //1,C:\\Temp\\AP_Mandats\\Projets archivés;
        for (RootUrl rootUrl : Constants.getRootUrlArchive()) {
            File dir = new File(rootUrl.getUrl());
            if (dir.isDirectory()) {
                for (File f : dir.listFiles())
                    MandatsData.addMandat(f, 1);
                Msg.info("OK Dossier 'archive' => " + rootUrl);
            } else
                Msg.error("Dossier 'archive', n'existe pas. => " + rootUrl);
        }

        MandatsData.sortByAlapha();

        return mandats;
    }

    private static void addMandat(File f, int statut){
        String num = "000", name = "---", file = f.getName();

        if(f.isDirectory()){

            //Num
            if(f.getName().indexOf("-") > 0)
                num = f.getName().substring(0, f.getName().indexOf("-")).trim();

            //Name
            if(f.getName().indexOf("-") > 0 && f.getName().length() > f.getName().indexOf("-"))
                name = f.getName().substring(f.getName().indexOf("-")+1).trim();

            MandatsData.mandats.getAll().add(new Mandat(num, name, f.toString(), statut));
        }
    }

    private static void sortByAlapha(){
        Collections.sort(mandats.getAll(),Comparator.comparing(Mandat::getNumMandat));
    }
}
