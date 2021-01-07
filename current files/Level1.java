import java.util.*;

public class Level1 {

<<<<<<< HEAD
    static boolean MisterRobot(int N, int [] data){

        int offset = N - 1;
        int temp = 0;
        boolean canBeSorted = false;

        int [] sortedArr = new int[data.length];
        for (int a = 0; a < data.length; a++) {
            sortedArr[a] = data[a];
        }
        Arrays.sort(sortedArr);

        //checking rightmost values, descending from the end
        for (int i = data.length - 1; i > 0; i--){
            if (!(data[i] == N)){
                offset = i;
                break;
            }
            N--;
=======
    static boolean LineAnalysis(String line) {
        int firstDot = 0;
        int marker = 0;
        boolean match = true;
        firstDot = line.indexOf(".");
        marker = line.indexOf("*", firstDot);
        String pattern = line.substring(0, marker);
        StringBuilder sb1 = new StringBuilder(line);
        sb1.delete(0, marker);
        System.out.println("pattern: " + pattern);

        // if no dots present
        if (!(line.contains("."))){
            return true;
        }
        // if string is "*.*"
        if (line.equals("*.*")){
            return true;
>>>>>>> 32a9c3d67f330ec94d75cb692deb28fbe87f011b
        }

        //loop through remaining elements of testN, descending
        for (int j = offset; j >= 2; j--){

            //rotating 3 elements to the left
            for (int r = 0; r < 3; r++) {

                //if rightmost element is the biggest
                if (data[j] > data[j - 1] && data[j] > data[j - 2]) {
                    break;
                }

                //moving left
                else {
                    temp = data[j - 2];
                    data[j - 2] = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }

            }
        }

        if (Arrays.equals(data, sortedArr)) {
            canBeSorted = true;
        }

        return canBeSorted;
    }

}
