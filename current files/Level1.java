import java.util.*;

public class Level1 {

    public static boolean TransformTransform(int A[], int N) {
            int checkSum = 0;
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list3;
            for (int b = 0; b < A.length; b++){
                list1.add(A[b]);
            }

            list3 = transform1(transform1(list1));

            for (int c = 0; c < list3.size(); c++){
                checkSum = checkSum + list3.get(c);
            }
            System.out.println(checkSum);
            if (checkSum % 2 == 0) {
                return true;
            }
            else return false;
    }

    public static ArrayList<Integer> transform1(ArrayList<Integer> inputList){
        int k;
        int max;
        ArrayList<Integer> transformedList = new ArrayList<>();

        for (int i = 0; i <= inputList.size() - 1; i++){
            for (int j = 0; j <= inputList.size() - i - 1; j++){
                k = i + j;

                    max = inputList.get(j);
                    for (int a = j; a <= k; a++){
                        if(inputList.get(a) > max) max = inputList.get(a);
                    }
                        transformedList.add(max);
                }
            }


        return transformedList;
    }

}