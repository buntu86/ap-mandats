package ch.pillonel.tools;

public class Convertion {
    public static int stringToInteger(java.lang.String str){
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public static java.lang.String intToString(int i){
        return Integer.toString(i);
    }
}
