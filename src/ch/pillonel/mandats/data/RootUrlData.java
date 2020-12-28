package ch.pillonel.mandats.data;

import ch.pillonel.mandats.model.RootUrl;
import ch.pillonel.tools.Msg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RootUrlData {

    private static List<RootUrl> listRootUrl = new ArrayList<>();

    public static List<RootUrl> ini(){
        try (Stream<String> stream = Files.lines(Paths.get(ConfigData.getUrlRootFile()))) {
            stream.forEach(s -> listRootUrl.add(new RootUrl(s)));
        } catch (IOException e) {
            Msg.error("Impossible de lire le fichier de configuration 'urlRoot.txt' -> " + e.getMessage());
            System.exit(2);
        }

        return listRootUrl;
    }
}
