import java.util.*;

public class MrRobot {
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

    public static void main(String[] args) {
        int n = 7;
        int [] testN = new int[]{2,3,5,4,6,7,1};


        System.out.println(MisterRobot(6, testN));



    }
}
