import java.util.*;

public class Tanks {

    //find substring match(es) in string, assuming there's at least 1 match (using .contains)
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

    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        boolean found = false;
        int arr2row1 = 0; //second array first row
        int start1 = 0;
        int start2 = 0;
        String Arr1[] = new String[H1];
        String Arr2[] = new String[H2];


        //filling up both arrays
        for (int i = 0; i < H1; i++) {
            Arr1[i] = (S1.substring(start1, start1 + W1));
            start1 = start1 + W1 + 1;
            System.out.println(Arr1[i]);
        }
        for (int i = 0; i < H2; i++) {
            Arr2[i] = (S2.substring(start2, start2 + W2));
            start2 = start2 + W2 + 1;
            System.out.println(Arr2[i]);
        }

        //main loop
        for (int j = 0; j < H1; j++) {

            if (!(Arr1[j].contains(Arr2[arr2row1]))) {
                continue;
            }
            if (j == H1 - 1) {
                break;
            }

            int[] matchIndex = findElementIndex(Arr1[j], Arr2[arr2row1]);
            int strLength = matchIndex.length;

            //checking all matches in one row (j)
            for (int m = 0; m < strLength; m++) {

                //moving down
                for (int r = j + 1, s = 1; s < H2; r++, s++) {

                    if (!((Arr1[r].contains(Arr2[s]) && Arr1[r].indexOf(Arr2[s]) == matchIndex[m]))) {
                        break;
                    }

                    found = true;
                }
                if (found) break;

            }
            if (found) break;

        }
        return found;
    }




    public static void main(String[] args) {

        String Str1 = "029402 560202 029694 780288";
        String Str2 = "02 94";

        System.out.println(TankRush(4, 6, Str1, 2, 2, Str2));


    }
}
