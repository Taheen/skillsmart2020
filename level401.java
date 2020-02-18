package mylessons;
import java.util.*;

public class level3 {
	
	public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {
		
	    int ids1[] = ids;
	    int salary1[] = salary;
	    int finalSalary1[] = new int [N];
	    int a = 0;
	    int b = 0;
	    int ids11[] = bubbleSort(ids1);
	    int salary11[] = bubbleSort(salary1);
	    
	    System.out.println(Arrays.toString(ids11));
	    System.out.println(Arrays.toString(salary11));
	    
	    for (a = 0; a < N; a++) {
	    	for (b = 0; b < N; b++) {
	    		if (ids1[a] == ids11[b]) {
	    			
	    			finalSalary1[a] = salary11[b];
	    		System.out.println(" ids1[a] " + ids1[a] + " in position " + a + " equals ids11[b] "  + ids11[b] + " in position " + b);
			    
	    		}
	    			
	    	}
	    	
	    }
	    
	    return finalSalary1;
	}
	
	public static int [] bubbleSort (int[] list1) {
		int i, j;
		int temp = 0;
		for (i = 0; i < list1.length - 1; i++) {
			for (j = 0; j < list1.length - 1 - i; j++) {
				if (list1[j] > list1[j + 1]) {
					temp = list1[j];
					list1[j] = list1[j + 1];
					list1[j + 1] = temp;
				}
			}
		}
		return list1;
	}
	
	public static void main(String[] args) {
		  int testIDS[] = {3,1,7,8,4};
		  int testSALARY[] = {200, 100, 200, 300, 50};
		  
		  System.out.println(Arrays.toString(SynchronizingTables(5, testIDS, testSALARY)));
		 
		  System.out.println();
		
	}
}