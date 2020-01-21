package mylessons;
import java.util.*;

public class level33 {
	
	  public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
	    int conquerDays = 0;
	    int controlSum = 0;
		int maxCaptureDays = N + (M - 1); // rows + (columns - 1)
		int [][] playArea = new int [N][M];
		int numberOfTroops = L;
	    
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				playArea[i][j] = 0;
				}
		    }
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				controlSum = controlSum + playArea[i][j];
			  System.out.print(playArea[i][j]+" ");
			  }
			System.out.println();
		   }
		System.out.println("control sum is " + controlSum);
		
		
		return conquerDays;  
	  }
		
	  public static int horisontalAdvance(int [] testRow1, int rowDeploy) {
		int rowLength1 = testRow1.length;
		int drop1 = rowDeploy;
		int movementDays = 1;
		
		testRow1[drop1] = 1;
			
			for (int i = 1; i < rowLength1; i++) {
				int controlSum1 = 0;
				if ((drop1 - i) >= 0) {
					testRow1[drop1 - i] = 1;
				  }
				
				if ((drop1 + i) < rowLength1) {
					testRow1[drop1 + i] = 1;
				  }
				
				for(int k = 0; k < rowLength1; k++) {
					controlSum1 = controlSum1 + testRow1[k];
					  System.out.print(testRow1[k] + " ");
				    }
				  System.out.println("controlsum is " + controlSum1);
				movementDays = movementDays + 1;
				if (controlSum1 == rowLength1)
					break;
			  }
		   return movementDays;
		}
	  
	  public static void main(String[] args) {

	  
	  int [] testAdvance1 = {0,0,0,0,0,0,0,0};
	  int testRowDeploy = 5;
	  System.out.println(horisontalAdvance(testAdvance1, testRowDeploy) + " days to conquer the row");
	  //int [] deploy2 = {3,4};
	
}
}
