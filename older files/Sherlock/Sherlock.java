import java.util.*;

public class Sherlock {

    public static boolean SherlockValidString(String s){

        boolean result1 = true;
        int max = 1;
        Map<Character, Integer> map1 = new HashMap<>();
        char[] chars1 = s.toCharArray();
        map1.put(chars1[0],1);

        for (int i = 1; i < chars1.length; i++){
            if (map1.containsKey(chars1[i])){
                map1.replace(chars1[i], map1.get(chars1[i]) + 1);
            }
            else {
                map1.put(chars1[i], 1);
            }
        }

        int size = map1.size();
        ArrayList<Integer> ints1 = new ArrayList<>(map1.values());

        //getting maxvalue
        for (int i = 0; i < size; i++) {
            if (ints1.get(i) > max) {
                max = ints1.get(i);
            }
        }

        //checking for value difference > 1
        for (int i = 0; i < size; i++){
            if (max - ints1.get(i) > 1) {
                return false;
            }
        }

        //calculating number of occurrences
        int counter1 = 1;
        int counter2 = 0;
        for (int j = 1; j < size; j++){
            if (ints1.get(j) != ints1.get(0)){
                counter2++;
            }
            else counter1++;
        }
        // if more than 1 of each values - false
        if ((counter1 > 1) && (counter2 > 1)){
            return false;
        }

        return result1;
    }

    public static void main(String[] args) {


        String test = "xxyyzabc";
        System.out.println(SherlockValidString(test));



    }
}
