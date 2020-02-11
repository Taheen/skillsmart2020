package mylessons;
import java.util.*;

public class level33 {
	
	public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
		boolean captureComplete = false; // trigger of completion
	    int controlSum = 0;
	    int conquerDays = 1;
	    int maxConquerDays = N + M - 1; // maximum capture days
	    int numberOfDrops = L;
	    int dropRow = battalion[0]; // initial drop row
	    int dropColumn = battalion[1]; // initial drop column
	    int playArea[][] = new int [N][M]; //setting up matrix of given size
		for (int i = 0; i < N; i++) { //filling playArea with 0
			for (int j = 0; j < M; j++) {
				playArea[i][j] = 0;
			}
		}
		
		playArea[dropRow][dropColumn] = 1; // initial drop set to 1
		
		for (int cycle = 1; cycle < maxConquerDays; cycle++) { // this is the main cycle counting capture days
			
		    int [] nextMove1;
		    
		    for (int i = 0; i < N; i++) {
			    for (int j = 0; j < M; j++) {
				    controlSum = controlSum + playArea[i][j];
			        System.out.print(playArea[i][j]+" ");
			    
			        if (controlSum == N * M) {
			    	captureComplete = true; // all fields are == 1
			    	break;
			        }
			    }
			    System.out.println();
			    if (captureComplete) // all fields are == 1
		    	    break;
		    }
		    // first conquest complete, moving to next steps
		    
		    nextMove1 = advance(dropRow, dropColumn, N, M);
		    for (int a = 0; a < nextMove1.length; a += 2) {  //cycling through nextMove1 array, assigning 1s to fields
		        playArea[nextMove1[a]][nextMove1[a + 1]] = 1;	
		    }
		    
		    if (captureComplete) // all fields are == 1
		    	break;
		}
			
		System.out.println("control sum is " + controlSum);
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
	
	public static void main(String[] args) {
		int N = 5;
		int M = 5;
		int dropRow = 2;
		int dropColumn = 2;
		int elementAt;
		
	
		System.out.println(Arrays.toString(advance(1,1,4,4)));
		
		
		
		
	}
}