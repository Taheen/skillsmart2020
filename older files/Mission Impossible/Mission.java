import java.util.*;

public class Mission {

    //main method
    public static String TheRabbitsFoot(String S, boolean encode){
        if (encode == true) {
            int rows = (matrixSize(removeSpaces(S))[0]);
            int cols = (matrixSize(removeSpaces(S))[1]);
            char[][] ch = new char[rows][cols];
            String S1 = removeSpaces(S); //spaces removed
            int count = 0;
            //filling up charArray
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    ch[i][j] = S1.charAt(count);
                    count++;
                    if (count == S1.length()) {
                        break;
                    }
                }
            }
            StringBuilder str = new StringBuilder();
            for (int s1 = 0; s1 < rows; s1++) {
                for (int s2 = 0; s2 < rows; s2++) {
                    str.append(ch[s2][s1]);
                }
                str.append(" ");
            }
            String someString1 = str.toString();
            return someString1.trim();
        }

        else {
            int counter2 = 0;
            int counter2limit = removeSpaces(S).length();

            StringBuilder str2 = new StringBuilder();
            String[] splitStr = S.split("\\s+");

            char [][] ch2 = new char[splitStr[0].length()][splitStr[0].length()];
            for (int i = 0; i < splitStr[0].length(); i++){
                for(int j = 0; j < splitStr[0].length(); j++){
                    str2.append(splitStr[j].charAt(i));
                    counter2++;
                    if (counter2 == counter2limit){
                        break;
                    }
                }
                if (counter2 == counter2limit){
                    break;
                }
            }
            String someString2 = str2.toString();
            return someString2.trim();
        }

    }

    //removing spaces in given string
    public static String removeSpaces(String inputStr){
        String resultString = inputStr.replaceAll("\\s+","");
        return resultString;
    }

    //calculating the size of final array
    public static int[] matrixSize(String inputStr){
        int strLen = inputStr.length();
        double strLenSqrt = Math.sqrt(strLen);
        int lowerSqrt = (int) strLenSqrt;
        int higherSqrt = lowerSqrt + 1;
        if ((lowerSqrt * higherSqrt) < strLen){
            lowerSqrt++;
        }
        int [] resultArray = {lowerSqrt, higherSqrt};
        return resultArray;
    }

}
