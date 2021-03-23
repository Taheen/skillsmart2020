import java.util.*;

public class Level1 {

        public static String [] TreeOfLife(int H, int W, int N, String [] tree){

            int yearCount = 0;
            int yearLimit = N;
            char[][] test2Tree = new char[H][W];
            char[][] marked4death = new char[H][W];

            //creating chararray(s)
            for (int i = 0; i < H; i++){
                for (int j = 0; j < W; j++){
                    if (tree[i].charAt(j) == '.') {
                        test2Tree[i][j] = '.';
                    }
                    else {
                        test2Tree[i][j] = '1';
                    }
                    marked4death[i][j] = 'o';
                }
            }

            //main loop (years of modelling)
            for (int y = 0; y < yearLimit; y++){
                if (yearCount % 2 == 0){
                    firstYear(test2Tree);
                }

                else {
                    secondYear(test2Tree);
                    for (int i = 0; i < H; i++){
                        for (int j = 0; j < W; j++){
                            if (test2Tree[i][j] >= '3'){
                                marked4death[i][j] = 'x';
                            }
                            else marked4death[i][j] = 'o';
                        }
                    }
                    deleteFields(test2Tree,marked4death);
                }
                yearCount++;
            }

            for (int i = 0; i < H; i++){
                for (int j = 0; j < W; j++){
                    if (test2Tree[i][j] != '.')
                        test2Tree[i][j] = '+';
                }
            }
            String[] finalResult = new String[H];
            for (int i = 0; i < H; i++){
                finalResult[i] = new String(test2Tree[i]);
            }

            return finalResult;
        }

        //first year growth
        public static char[][] firstYear(char[][] inputChar1){
            int h1 = inputChar1.length;
            int w1 = inputChar1[0].length;

            for (int i = 0; i < h1; i++){
                for (int j = 0; j < w1; j++){
                    if (inputChar1[i][j] == '.') {
                        inputChar1[i][j] = '1';
                    }
                    else {
                        inputChar1[i][j] += 1;
                    }
                }
            }
            return inputChar1;
        }

        //second year growth + death
        public static char[][] secondYear(char[][] inputChar2){
            int h2 = inputChar2.length;
            int w2 = inputChar2[0].length;

            for (int i = 0; i < h2; i++){
                for (int j = 0; j < w2; j++){
                    inputChar2[i][j] += 1;
                }
            }
            return inputChar2;
        }

        //marking fields for destruction
        public static char[][] deleteFields(char[][] inputChar3, char[][] deathMap){
            int h3 = inputChar3.length;
            int w3 = inputChar3[0].length;

            for (int i = 0; i < h3; i++){
                for (int j = 0; j < w3; j++){
                    if (deathMap[i][j] == 'x'){
                        inputChar3[i][j] = '.';
                        if (i > 0) inputChar3[i - 1][j] = '.';
                        if (i < h3 - 1) inputChar3[i + 1][j] = '.';
                        if (j > 0) inputChar3[i][j - 1] = '.';
                        if (j < w3 - 1) inputChar3[i][j + 1] = '.';
                    }
                }
            }
            return inputChar3;
        }
}