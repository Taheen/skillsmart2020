import java.util.*;

public class Level1 {
	
	public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
		boolean captureComplete = false; // trigger of completion
	    int conquerDays = 0;
	    int playArea[][] = new int [N][M]; //setting up matrix of given size
		for (int i = 0; i < N; i++) { //filling playArea with 0
			for (int j = 0; j < M; j++) {
				playArea[i][j] = 0;
			}
		}
		int [] nextMove1 = battalion; // next move array
		int [] nextMove2;
		int [] nextMoveTemp = new int [0];
		for (int cycle = 1; cycle < M + N - 1; cycle++) {
			int controlSum = 0;
		
		    for (int adv = 0; adv < nextMove1.length; adv +=2) {
	            if (playArea[nextMove1[adv]] [nextMove1[adv + 1]] != 1) { //checking if the field not already set to 1 
	        	    playArea[nextMove1[adv]] [nextMove1[adv + 1]] = 1; // assigning 1 to the field
	                nextMove2 = advance(nextMove1[adv], nextMove1[adv + 1], N, M);  //advancing to next field(s)
	                nextMoveTemp = addX(nextMoveTemp, nextMove2);
	            }
		    }
		    nextMove1 = nextMoveTemp;
		    nextMoveTemp = new int [0];
		    conquerDays++;
		    
		    for (int i = 0; i < N; i++) {
		        for (int j = 0; j < M; j++) {
			        controlSum = controlSum + playArea[i][j];
		        
	            }
		    }
		       
		    if (controlSum == N * M) 
		        break;
		    
		}
		return conquerDays;  
	}
	
	public static int[] advance (int row1, int column1, int N1, int M1) { //checking nearby fields and advancing
		ArrayList<Integer> testList100 = new ArrayList<>();
		if (row1 - 1 >= 0) {
			testList100.add(row1 - 1);
		    testList100.add(column1);
		}
		if (row1 + 1 < N1) {
			testList100.add(row1 + 1);
		    testList100.add(column1);
		}
		if (column1 - 1 >= 0) {
			testList100.add(row1);
		    testList100.add(column1 - 1);
		}
		if (column1 + 1 < M1) {
			testList100.add(row1);
		    testList100.add(column1 + 1);
		}
		int [] testArray100 = new int [testList100.size()];
		for (int i = 0; i < testArray100.length; i++)
			testArray100[i] = testList100.get(i);
		
		return testArray100;
	}
	
public static int[] addX(int[] arr111, int[] arr222) {  //concatenation of 2 arrays without using <arraycopy>
		
		int [] testArray200 = new int [arr111.length + arr222.length];
		int pos = 0;
		for (int element : arr111) {
			testArray200[pos] = element;
			pos++;
		}
		for (int element : arr222) {
			testArray200[pos] = element;
			pos++;
		}
		return testArray200;
		
	}

public static void main(String[] args) {
   int test[] = {0,0,2,2};
}





}