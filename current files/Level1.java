import java.util.*;

public class Level1 {
    public static String BigMinus(String s1, String s2){
        long L1 = Long.parseLong(s1);
        long L2 = Long.parseLong(s2);
        long extract = 0;

        if (L1 > L2) {
            extract = L1 - L2;
        }
        if (L1 < L2) {
            extract = L2 - L1;
        }
        String result = Long.toString(extract);
        return result;
    }

}
