package ch.pillonel.mandats.data;

import ch.pillonel.tools.Msg;

import java.io.File;
import java.io.IOException;

public class ConfigData {

    private static final String dir = new String("./resources/"), file = new String("urlRoot.txt");

    private static void setResourcesDir(){
        if(new File(dir).exists())
            Msg.info("OK dir '"+ dir + "' exists");
        else{
            File tmp = new File(dir);
            tmp.mkdir();
            Msg.info("WORK create dir '" + dir + "'");
        }
    }

    public static String getUrlRootFile() {
        ConfigData.setResourcesDir();

        if (new File(dir + file).exists()) {
            Msg.info("OK file '" + dir + file + "' exist");
        } else {
            Msg.info("WORK create file '" + dir + file + "'");
            try {
                new File(dir + file).createNewFile();
            } catch (IOException e) {
                Msg.error("Impossible de créer le fichier de configuration 'urlRoot.txt' -> " + e.getMessage());
                System.exit(1);
            }
        }
        return dir + file;
    }
}
