import java.util.Arrays;

public class Harry {

    public static String BiggerGreater (String input){

        char temp;
        char[] inputArr = input.toCharArray();
        int arrlength = inputArr.length;

        if (arrlength == 2){
            if (inputArr[1] > inputArr[0]) {
                temp = inputArr[0];
                inputArr[0] = inputArr[1];
                inputArr[1] = temp;
                String resultLength2 = new String(inputArr);
                return resultLength2;
            }
            else return "";
        }

        int marker1 = isNotDescending(inputArr);
        if (marker1 == -1){
            return "";
        }

        // marker == arrlength - 2, swapping last 2 chars
        if (marker1 == arrlength - 2){
            char temp2 = inputArr[arrlength - 1];
            inputArr[arrlength - 1] = inputArr[arrlength - 2];
            inputArr[arrlength - 2] = temp2;
        }

        // splitting array after marker1
        char[] arr1 = new char[marker1 + 1];
        char[] arr2 = new char[arrlength - (marker1 + 1)];

        for (int m = 0; m < marker1 + 1; m++){
            arr1[m] = inputArr[m];
        }
        for (int t = 0, n = marker1 + 1; n < arrlength; n++, t++){
            arr2[t] = inputArr[n];
        }

        int d = isNotDescending(arr2);
        if (d == -1) {
            //finding next bigger (than marker) char in suffix, swapping with marker1
            for (int b = arr2.length - 1; b >= 0; b--) {
                if (arr2[b] > arr1[arr1.length - 1]) {
                    int marker2 = b;
                    char temp2 = arr1[arr1.length - 1];
                    arr1[arr1.length - 1] = arr2[marker2];
                    arr2[marker2] = temp2;
                    break;
                }
            }
            Arrays.sort(arr2);
        }

        String finalResult = String.valueOf(arr1) + String.valueOf(arr2);
        return finalResult;
    }

    // check if array is not descending (return -1 if true)
    public static int isNotDescending (char[] inputChArr){
        int result = -1;
        for (int j = inputChArr.length - 1; j > 0;  j--){
            if (inputChArr[j] > inputChArr[j - 1]){
                 result = j - 1;
                 break;
            }
         }
        return  result;
    }


    public static void main(String[] args) {

        String test1 = "яя";
        String test2 = "ффф";
        String test3 = "нклм";
        String test4 = "вибк";
        String test5 = "вкиб";



        System.out.println(BiggerGreater(test1));
        System.out.println("------------------");
        System.out.println(BiggerGreater(test2));
        System.out.println("------------------");
        System.out.println(BiggerGreater(test3));
        System.out.println("------------------");
        System.out.println(BiggerGreater(test4));
        System.out.println("------------------");
        System.out.println(BiggerGreater(test5));
        System.out.println("------------------");



    }
}
