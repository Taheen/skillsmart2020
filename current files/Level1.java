import java.util.*;

public class Level1 {

    public static boolean SherlockValidString(String s){
        boolean result = true;
        int charCount = 0;
        char[] chars = s.toCharArray();


        return result;
    }

    public static void main(String[] args) {
        Map<Character, Integer> map1 = new HashMap<>();

        map1.put('a', 3);
        map1.put('b', 4);
        map1.put('c', 11);

        System.out.println(map1);
        System.out.println(map1.get('b') < map1.get('c'));

        map1.put('a', 4);
        System.out.println(map1);

    }

}