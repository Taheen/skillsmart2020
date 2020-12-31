import java.util.*;

public class Patterns {

    static boolean LineAnalysis(String line) {
        int firstDot = 0;
        int marker = 0;
        boolean match = true;
        firstDot = line.indexOf(".");
        marker = line.indexOf("*", firstDot);
        String pattern = line.substring(0, marker);
        StringBuilder sb1 = new StringBuilder(line);
        sb1.delete(0, marker);

        // if no dots present
        if (!(line.contains("."))){
            match = true;
        }
        // if string is "*.*"
        if (line.equals("*.*")){
            match = true;
        }

        for (int i = 0; i < sb1.length() - 1; i++){

            if (sb1.indexOf(pattern) == 0){
                sb1.delete(0, marker);

                //remaining string shorter than pattern, no match
                if (sb1.length() > 1 && sb1.length() <= pattern.length()){
                    match = false;
                    break;
                }
            }

            //no match
            else {
                match = false;
                break;

            }
        }

        return match;
    }


    public static void main(String[] args) {
        String test1 = "**..**..**..*";

         System.out.println(LineAnalysis(test1));
    }
}
