import java.util.*;

public class Level1 {

    public static void MatrixTurn(String Matrix[], int M, int N, int T) {

        int ringAmount;
        char[][] testArr = new char[M][N];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                testArr[i][j] = Matrix[i].charAt(j);
            }
        }

        //calculating amount of "rings", we will rotate them separately
        if (M > N) {
            ringAmount = N/2;
        }
        else ringAmount = M/2;

        //  ---- main loop (number of rotations) ----
        for (int s = 0; s < T; s++){

            // ---- inner loop (rotating rings starting from outer ring) ----
            for (int r = 0; r < ringAmount; r++){
                rotationClockwise(testArr, currentRingBorders(testArr, r));
            }

        }

        for (int i = 0; i < Matrix.length; i++){
            Matrix[i] = new String(testArr[i]);
        }

    }

    //ring coordinates(top left corner, height, length)
    public static int[] currentRingBorders (char[][] inputArr1, int ring){
        int[] borders = new int[3];
        int s = ring;
        borders[0] = s;
        borders[1] = inputArr1.length - 1 - s;
        borders[2] = inputArr1[0].length - 1 - s;
        return borders;
    }

    public static void rotationClockwise (char[][] arr2rotate, int[] borders){
        char temp;
        temp = arr2rotate[borders[0]][borders[2]];

        //top row moved right
        for (int i = borders[2] - 1; i >= borders[0]; i--){
            arr2rotate[borders[0]][i + 1] = arr2rotate[borders[0]][i];
        }

        //left column moved up
        for (int i = 0; i < borders[1]; i++){
            arr2rotate[borders[0] + i][borders[0]] = arr2rotate[borders[0] + 1 + i][borders[0]];
        }

        //bottom row moved left
        for (int i = borders[0]; i < borders[2]; i++){
            arr2rotate[borders[1]][i] = arr2rotate[borders[1]][i + 1];
        }

        //right column moved down + insert temp
        for (int i = borders[1]; i > borders[0] + 1; i--){
            arr2rotate[i][borders[2]] = arr2rotate[i - 1][borders[2]];
        }
        arr2rotate[borders[0] + 1][borders[2]] = temp;
    }
}