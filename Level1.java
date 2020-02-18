import java.util.*;

public class Level1 {
	public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {
		
	    int ids1[] = new int [N];
	    for (int s = 0; s < N; s++) {
	    	ids1[s] = ids[s];
	    }
	    
	    int finalSalary1[] = new int [N];
	    int a = 0;
	    int b = 0;
	    int idsNew[] = bubbleSort(ids);
	    int salaryNew[] = bubbleSort(salary);
	    
	    for (a = 0; a < N; a++) {
	    	for (b = 0; b < N; b++) {
	    		if (ids1[a] == idsNew[b]) {
	    			finalSalary1[a] = salaryNew[b];
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
	
	
}
