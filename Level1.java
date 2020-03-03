import java.util.*;

public class Level1 {
	
public static String PatternUnlock(int N, int [] hits)  {
		
		int [][] phoneScreen = { {6, 1, 9}, {5, 2, 8}, {4, 3, 7} };
		//  6 1 9    dots on the phone screen
		//  5 2 8
		//  4 3 7
		
		double finalSum = 0;
		int [] position = new int [2];
		int currentValue;
		position = indexOfIntArray(phoneScreen, hits[0]); //starting point
		int rowPosition = position[0];
		int colPosition = position[1];
		int newRowPosition, newColPosition;
		
		for (int i = 1; i < N; i++) { // main cycle iterating through all dots in hitsTest array
			currentValue = hits[i];
			position = indexOfIntArray(phoneScreen, currentValue);
			newRowPosition = position[0];
			newColPosition = position[1];
			if (newRowPosition == rowPosition || newColPosition == colPosition) {
				finalSum = finalSum + 1; //if next dot move is vertical or horisontal
			    }
			else finalSum = finalSum + 1.41421; // if next dot move is diagonal
			
			rowPosition = newRowPosition;
			colPosition = newColPosition;
		}
		String strNew1 = String.format("%.05f", finalSum); //rounding up to 5 decimal digits
		String strNew2 = strNew1.replace(".", ""); //removing dot
		String FinalResult = strNew2.replace("0", ""); //removing zeros
		
	    return FinalResult;
	}
	
	public static int [] indexOfIntArray(int[][] array, int key) {  // this is a replacement method for indexOf 
		boolean breakControl = false;
	    int returnvalue1 = -1;
	    int returnvalue2 = -1;
	    
	    for (int i = 0; i < array.length; ++i) {
	    	for (int j = 0; j < array[i].length; j++) {
	            if (key == array[i][j]) {
	                returnvalue1 = i;
	                returnvalue2 = j;
	                breakControl = true;
	                break;
	            }
	    	}
	    	if (breakControl)
            	break;
	    }
	    int indexOf[] = {returnvalue1, returnvalue2};
	    return indexOf;
	}

}
