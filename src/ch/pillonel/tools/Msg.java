package ch.pillonel.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Msg {

    private static List<String> listMsg = new ArrayList<>();

    public static void error(String s) {
        String str = "ERROR::" + s;
        listMsg.add(str);
        System.out.println(str);
    }

    public static void info(String s) {
        String str = "INFO::" + s;
        listMsg.add(str);
        System.out.println(str);
    }

    public static void saveMsg(){
        StringBuilder str = new StringBuilder();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        str.append("--- Export log at " + format.format(date) + " ---" + "\n");
        
        listMsg.forEach(s -> str.append(s + "\n"));

        try {
            System.out.println(str);
            Files.write(Paths.get("./log.txt"), str.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        info("F12 pressed -> list of msg save to log.txt");
    }
}
