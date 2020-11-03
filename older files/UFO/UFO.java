import java.util.*;

public class UFO {
    public static int [] UFO (int N, int [] data, boolean octal){

        int [] finalResult = new int [data.length];
        String [] str1 = new String[data.length];
        int decimal8;
        int decimal16;
        for (int i = 0; i < data.length; i++){
            str1[i] = String.valueOf(data[i]);
        }
        for (int j = 0; j < str1.length; j++){
            if (octal){
                decimal8 = Integer.parseInt(str1[j], 8);
                finalResult[j] = decimal8;
            }
            else {
                decimal16 = Integer.parseInt(str1[j], 16);
                finalResult[j] = decimal16;
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int [] testArr = {1234, 1777, 1212};


        System.out.println(Arrays.toString(UFO(5, testArr, true)));
        System.out.println(Arrays.toString(UFO(5, testArr, false)));


    }
}
