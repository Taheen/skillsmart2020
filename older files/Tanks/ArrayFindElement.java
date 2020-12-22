import java.util.*;

public class ArrayFindElement {

    //method finds substring in the string and returns it's index (or multiple indexes)

    public static int[] findElementIndex(String inputArr, String element) {

        int offset = 0;
        ArrayList<Integer> myNumbers = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder(inputArr);

        for (int j = 0; j < sb1.length(); j++) {

            if (sb1.indexOf(element) == sb1.lastIndexOf(element)){
                myNumbers.add(sb1.indexOf(element) + offset);
                break;
            }
            else {
                myNumbers.add(sb1.indexOf(element) + offset);
                offset = offset + sb1.indexOf(element) + element.length();
                sb1.delete(0, sb1.indexOf(element) + element.length());
            }
        }

        int [] result = new int[myNumbers.size()];
        for (int k = 0; k < result.length; k++) {
                result[k] = myNumbers.get(k);
            }
        return result;
        }

        public static void main (String[]args){

        String Str1 = "02402410217002";
        String Str2 = "02";
        System.out.println(Arrays.toString(findElementIndex(Str1, Str2)));




        }
}
