package mylessons;
import java.util.*;

public class Level15 {
	
	// main search method
	public static int [] WordSearch(int len, String s, String subs) { 
		int row = 0; 
		int len1 = len;
		int sLength = s.length();
		char strBase [] = s.toCharArray();
		String subS1 = "";
		String tempStr = "";
		String finalStr = "";
		int a1 = 0;
		int a2 = 0;
		int marker = 0;  // row with the matching word
		boolean matchFound = false;
		
        for (int j = 0; j < sLength; j += len1) {
			
		
		    for (int i = 0; i < len1; i++) {
			
	    		if (strBase[i] == ' ' && i < (len1 - 1)) { // if space in a row, but not at the end
		    	    a2 = i;
			        subS1 = s.substring(a1, a2);
			        System.out.println(a1 + " " + a2 + " " + subS1);
			        if (subS1.equals(subs)) {
			        	System.out.println("match in row " + row);
			    	    matchFound = true;
			    	    marker = row;
			        }
			        a1 = a2 + 1;
			        System.out.println("a1 is now = " + a1);
			        tempStr = tempStr + subS1 + " ";
			    }  
			
			    if (strBase[i] == ' ' && i == (len1 - 1)) {  // if space is at the end of the row
				    a2 = i;
			        subS1 = s.substring(a1, a2);
			        System.out.println(a1 + " " + a2 + " " + subS1);
			        if (subS1.equals(subs)) {
			        	System.out.println("match in row " + row);
			    	    matchFound = true;
			    	    marker = row;
			        }
			        row++;
			        a1 = 0;
			        finalStr = tempStr + subS1 + "\n";
			    
			        if (s.charAt(0) == ' ') {
			        	s = s.substring(len1 + 1);
			        }
			        else {
			    	    s = s.substring(len1 + 1);
			        }
			    	
			        System.out.println("now working with: " + s);
			    }
			    
			
			    if (strBase[i] != ' ' && i == (len1 - 1)) { // if no spaces in a row
				    subS1 = s.substring(a1, len1);
			        System.out.println(a1 + " " + len1 + " " + subS1);
			        if (subS1.equals(subs)) {
			    	    System.out.println("match in row " + row);
			    	    matchFound = true;
			    	    marker = row;
			    	
			        }
			        row++;
			        a1 = 0;
			        finalStr = tempStr + subS1 + "\n";
			        if (s.charAt(0) == ' ') {
			    	    s = s.substring(len1 + 1);
			        }
			        else {
			    	    s = s.substring(len1 + 1);
			        }
			    	
			        System.out.println("now working with: " + s);
			    }
			
		    }
			
		}
		
		
		System.out.println(finalStr);
		int [] testArr = {0,0,1,0};
	    return testArr;
	}
	
		
	// 3 step need to split inputStr into 3 strings - before , range, after
	// range needs to be split using splitStringByLength - and inserted back, increasing length of input string
	public static String substringExtract (String inputStr, int[] range, int len1) {
		
		int s = inputStr.length();
		int cycle = range.length;
		String substrL = ""; // creating 3 substrings
		String substrM = "";
		String substrR = "";
		String substrMSplit = "";
		String finalString = "";
		
		for (int j = 0; j < cycle; j += 2) {  //if there is more than one "longer" word
		
		    substrL = inputStr.substring(0, range[0 + j] + j);
		    substrM = inputStr.substring(range[0 + j] + j, range[1 + j] + j);
		    substrMSplit = splitStringByLength(substrM, len1);
		
		    if (range[1 + j] < s) {
		       substrR = inputStr.substring(range[1 + j] + j, s);
		    }
		    else {
		       substrR = "";
		    }
		    finalString = substrL + substrMSplit + substrR;
		    inputStr = finalString;
		}
		return finalString;
	}
	
	// 2 step - splitting string by given length
	// inserting spaces in between words
	public static String splitStringByLength(String givenStr, int wordLength1) { 
		int L = (givenStr.length() / wordLength1); //number of iterations (splits) through the string
		StringBuilder str = new StringBuilder(givenStr);
		for (int i = 0; i <= L; i++) {
			if (i == 0) continue;
		    str.insert(((wordLength1 * i + i) - 1), ' '); // inserting ' ' after each L * i + i position
		}
		String splitResult = str.toString();
		return splitResult;
	}
	
	// 1 step - checking if there are words in the string longer than given length
	// returning start and end index of the word (as array)
	// also checking if there is more than one word (so it is a dynamic array)
	public static int [] checkWordLength(String startStr, int wordLength) { 
		char mStringtest [] = startStr.toCharArray();
		int positionStart = 0;
		int positionEnd = 0;
		int counter = 0;
		int a1 = 0;
		int a2 = 0;
		int L = mStringtest.length;
		
		ArrayList<Integer> aList100 = new ArrayList<>();
		
		for (int i = 0; i < L; i++) {
			if (mStringtest[i] == ' ') { // space ' ' is found
				a2 = i;
				// the word is shorter than given length -> do nothing
				if (a2 - 1 - a1 <= wordLength) {
					a1 = a2;
					continue;
				}
				// the word is longer than given length -> adding start and end indexes to array
				else {  
					positionStart = a1 + 1;
					positionEnd = a2 - 1;
					aList100.add(positionStart);
					aList100.add(positionEnd);
					a1 = a2;
				}
			}
		}
		//checking length of last word in the string (because no ' ' at the end of string)
		if (L - a1 > wordLength) {
			aList100.add(a1 + 1);
			aList100.add(L);
		}
		int [] position = new int [aList100.size()];
		for (int i = 0; i < position.length; i++)
			position[i] = aList100.get(i);
		return position;
	}
	public static void main(String[] args) {
		
	    String testStr1001 = ("this is a test for wordlengthlonger than seven characters");
	    int L1001 = 7;
	   // System.out.println(Arrays.toString(checkWordLength(testStr1001, L1001)));
	    System.out.println(substringExtract(testStr1001, checkWordLength(testStr1001, L1001), L1001));
	    int test2002 [] = WordSearch(7, "this is a test for wordlen gthlong er than seven charact ers", "seven");
	
	          
	    //System.out.println("Hello,\nWorld");
	}
}
