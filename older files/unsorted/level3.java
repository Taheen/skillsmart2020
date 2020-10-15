package mylessons;
import java.util.*;

public class level3 {
	
	  public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
	    int conquerDays = 0;
	   
	    
		return conquerDays;  
	  }
		
	  public static void main(String[] args) {

	  int controlSum = 0;
	  int maxCaptureDays = 4 + (5-1); // rows + (columns - 1)
	  int [] deploy1 = {2,2};
	  //int [] deploy2 = {3,4};
	  int [][] playArea = new int [4][5];
	  for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 5; j++) {
			playArea[i][j] = 0;
			}
	    }
	  
	  playArea[2][2] = 1; //deployment
	  
	  horisontalAdvance();{
		playArea[2 - 1][2] = 1;
		playArea
	  }
	  
	  
	  
	    for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				controlSum = controlSum + playArea[i][j];
			  System.out.print(playArea[i][j]+" ");
			  }
			System.out.println();
		   }
		System.out.println("control sum is " + controlSum);
		
		
	  }

	private static void horisontalAdvance() {
		// TODO Auto-generated method stub
		
	}
	}


}
