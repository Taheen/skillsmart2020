

public class Level1 {

    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2){
        boolean found = false;
        int safr = 0; //second array first row
        int start1 = 0;
        int start2 = 0;
        String Arr1[] = new String[H1];
        String Arr2[] = new String[H2];
        int matchIndex = -1;

        //filling up both arrays
        for (int i = 0; i < H1; i++){
            Arr1[i] = (S1.substring(start1, start1 + W1));
            start1 = start1 + W1 + 1;

        }
        for (int i = 0; i < H2; i++){
            Arr2[i] = (S2.substring(start2, start2 + W2));
            start2 = start2 + W2 + 1;

        }

        //main loop
        for (int j = 0; j < H1; j++){

            if (!(Arr1[j].contains(Arr2[safr]))){
                continue;
            }
            if (j == H1 - 1){

                break;
            }

            matchIndex = Arr1[j].indexOf(Arr2[safr]);


            for (int r = j + 1; r < H1; r++){
                if (!((Arr1[r].contains(Arr2[j]) && Arr1[r].indexOf(Arr2[j]) == matchIndex))) {


                    break;
                }
                found = true;

            }

        }

        return found;
    }

    
}
