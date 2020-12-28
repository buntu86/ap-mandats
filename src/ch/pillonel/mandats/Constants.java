package ch.pillonel.mandats;

import ch.pillonel.mandats.data.MandatsData;
import ch.pillonel.mandats.data.RootUrlData;
import ch.pillonel.mandats.model.Mandats;
import ch.pillonel.mandats.model.RootUrl;
import ch.pillonel.mandats.view.LeftPaneController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Constants {

    private static final Mandats mandats = new Mandats();
    private static List<RootUrl> listRootUrl = new ArrayList<>();
    private static LeftPaneController leftPane = null;

    public static void iniMandatsData(){
        listRootUrl = RootUrlData.ini();
        loadMandatsData();
    }

    public static void loadMandatsData(){
        Constants.mandats.getAll().clear();
        Constants.mandats.getAll().addAll(MandatsData.loadData().getAll());
    }

    public static List<RootUrl> getRootUrlArchive(){
        return listRootUrl.stream().filter(r -> r.getStatus().getStatut() == 1).collect(Collectors.toList());
    }

    public static List<RootUrl> getRootUrlActif(){
        return listRootUrl.stream().filter(r -> r.getStatus().getStatut() == 0).collect(Collectors.toList());
    }

    public static Mandats getMandatsData(){
        return Constants.mandats;
    }

    public static void setLeftPane(LeftPaneController leftPaneController) {
        if(leftPane == null)
            Constants.leftPane = leftPaneController;
    }

    public static LeftPaneController getLeftPane(){
        return Constants.leftPane;
    }
}
